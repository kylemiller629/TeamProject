package util;

import entity.Category;
import entity.ExternalQuote;
import entity.Quote;
import entity.QuoteCategory;
import persistence.ExternalQuoteDao;
import persistence.GenericDao;

import java.util.List;

public class QuoteDatabaseSeeder100 {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            ExternalQuote quote = getExternalQuote();

            if (quote != null) {
                insertQuote(quote);
            }
        }
    }

    public static ExternalQuote getExternalQuote() {
        ExternalQuoteDao externalDao = new ExternalQuoteDao(
                "https://api.api-ninjas.com/v1/quotes",
                System.getenv("API_NINJAS_KEY")
        );

        ExternalQuote externalQuote = externalDao.getQuote();

        if (externalQuote == null) {
            System.out.println("Failed to retrieve quote.");
        }

        return externalQuote;
    }

    public static void insertQuote(ExternalQuote externalQuote) {
        GenericDao<Quote> quoteDao = new GenericDao<Quote>(Quote.class);
        GenericDao<Category> categoryDao = new GenericDao<Category>(Category.class);
        GenericDao<QuoteCategory> quoteCategoryDao = new GenericDao<QuoteCategory>(QuoteCategory.class);

        List<Category> existingCategories = categoryDao.getByPropertyEqual("category", externalQuote.getCategory());
        List<Quote> existingQuotes = quoteDao.getByPropertyEqual("quote", externalQuote.getQuote());

        Quote quote;
        Category category;


        if (existingQuotes.isEmpty()) {
            quote = new Quote();
            quote.setQuote(externalQuote.getQuote());
            quote.setAuthor(externalQuote.getAuthor());
            quoteDao.insert(quote);
        } else {
            quote = existingQuotes.get(0);
        }


        if (existingCategories.isEmpty()) {
            category = new Category();
            category.setCategory(externalQuote.getCategory());
            categoryDao.insert(category);
        } else {
            category = existingCategories.get(0);
        }

        List<QuoteCategory> existingRelationships = quoteCategoryDao.getAll();

        boolean relationshipExists = false;

        for (QuoteCategory existing : existingRelationships) {

            if (existing.getQuote().getQuoteId() == quote.getQuoteId()
                    && existing.getCategory().getCategoryId() == category.getCategoryId()) {

                relationshipExists = true;
                break;
            }
        }

        if (!relationshipExists) {
            QuoteCategory quoteCategory = new QuoteCategory();
            quoteCategory.setQuote(quote);
            quoteCategory.setCategory(category);
            quoteCategoryDao.insert(quoteCategory);
        }
    }
}