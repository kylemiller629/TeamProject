
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
                "https://api.api-ninjas.com/v2/randomquotes",
                System.getenv("API_NINJAS_KEY")
        );

        ExternalQuote externalQuote = externalDao.getQuote();

        if (externalQuote == null) {
            System.out.println("Failed to retrieve quote.");
        }

        return externalQuote;
    }

    public static void insertQuote(ExternalQuote externalQuote) {
        GenericDao<Quote> quoteDao = new GenericDao<>(Quote.class);
        GenericDao<Category> categoryDao = new GenericDao<>(Category.class);
        GenericDao<QuoteCategory> quoteCategoryDao = new GenericDao<>(QuoteCategory.class);

        Quote quote = findOrCreateQuote(externalQuote, quoteDao);

        if (externalQuote.getCategories() == null) {
            return;
        }

        for (String categoryName : externalQuote.getCategories()) {
            Category category = findOrCreateCategory(categoryName, categoryDao);
            createRelationshipIfMissing(quote, category, quoteCategoryDao);
        }
    }

    private static Quote findOrCreateQuote(
            ExternalQuote externalQuote,
            GenericDao<Quote> quoteDao) {

        List<Quote> existingQuotes =
                quoteDao.getByPropertyEqual("quote", externalQuote.getQuote());

        if (!existingQuotes.isEmpty()) {
            return existingQuotes.get(0);
        }

        Quote quote = new Quote();
        quote.setQuote(externalQuote.getQuote());
        quote.setAuthor(externalQuote.getAuthor());

        quoteDao.insert(quote);

        return quote;
    }

    private static Category findOrCreateCategory(
            String categoryName,
            GenericDao<Category> categoryDao) {

        List<Category> existingCategories =
                categoryDao.getByPropertyEqual("category", categoryName);

        if (!existingCategories.isEmpty()) {
            return existingCategories.get(0);
        }

        Category category = new Category();
        category.setCategory(categoryName);

        categoryDao.insert(category);

        return category;
    }

    private static void createRelationshipIfMissing(
            Quote quote,
            Category category,
            GenericDao<QuoteCategory> quoteCategoryDao) {

        List<QuoteCategory> existingRelationships = quoteCategoryDao.getAll();

        for (QuoteCategory existing : existingRelationships) {
            if (existing.getQuote().getQuoteId() == quote.getQuoteId()
                    && existing.getCategory().getCategoryId() == category.getCategoryId()) {
                return;
            }
        }

        QuoteCategory quoteCategory = new QuoteCategory();
        quoteCategory.setQuote(quote);
        quoteCategory.setCategory(category);

        quoteCategoryDao.insert(quoteCategory);
    }
}
