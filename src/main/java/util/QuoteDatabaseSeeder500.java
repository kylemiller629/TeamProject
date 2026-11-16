package util;

import entity.Category;
import entity.ExternalQuote;
import entity.Quote;
import entity.QuoteCategory;
import persistence.ExternalQuoteDao;
import persistence.GenericDao;

import java.util.List;

/**
 * Retrieves quotes from an external API and saves quotes, categories,
 * and their relationships through the application's DAOs.
 *
 * The database destination is determined by the DAO/Hibernate configuration.
 * This class does not explicitly create database tables.
 */
public class QuoteDatabaseSeeder500 {

    public static void main(String[] args) {

        // Make 500 retrieval attempts. Failed requests or duplicate quotes
        // mean this may insert fewer than 500 new quotes.
        for (int i = 0; i < 500; i++) {
            ExternalQuote quote = getExternalQuote();

            // Only attempt to save a quote when the API returned one.
            if (quote != null) {
                insertQuote(quote);
            }
        }
    }

    /**
     * Requests a random quote using the API key from the environment.
     *
     * @return the retrieved quote, or null if no quote was returned
     */
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

    /**
     * Finds or inserts the quote, then saves any categories and links them
     * to the quote when those relationships do not already exist.
     *
     * @param externalQuote the quote returned by the external API
     */
    public static void insertQuote(ExternalQuote externalQuote) {
        GenericDao<Quote> quoteDao = new GenericDao<>(Quote.class);
        GenericDao<Category> categoryDao = new GenericDao<>(Category.class);
        GenericDao<QuoteCategory> quoteCategoryDao =
                new GenericDao<>(QuoteCategory.class);

        // Reuse a matching quote or insert a new one.
        Quote quote = findOrCreateQuote(externalQuote, quoteDao);

        // The quote has already been handled. If there are no categories,
        // skip category processing.
        if (externalQuote.getCategories() == null) {
            return;
        }

        // Find or insert each category, then link it to the quote.
        for (String categoryName : externalQuote.getCategories()) {
            Category category = findOrCreateCategory(categoryName, categoryDao);
            createRelationshipIfMissing(quote, category, quoteCategoryDao);
        }
    }

    /**
     * Looks for an existing quote with matching quote text.
     * If one exists, returns the first match; otherwise, inserts a new quote.
     *
     * @param externalQuote the external quote to save
     * @param quoteDao the DAO used to query and insert quotes
     * @return the existing or newly inserted quote
     */
    private static Quote findOrCreateQuote(
            ExternalQuote externalQuote,
            GenericDao<Quote> quoteDao) {

        // Duplicate detection uses quote text, without checking the author.
        List<Quote> existingQuotes =
                quoteDao.getByPropertyEqual("quote", externalQuote.getQuote());

        if (!existingQuotes.isEmpty()) {
            return existingQuotes.get(0);
        }

        // Copy the external API's values into the database entity.
        Quote quote = new Quote();
        quote.setQuote(externalQuote.getQuote());
        quote.setAuthor(externalQuote.getAuthor());

        quoteDao.insert(quote);

        return quote;
    }

    /**
     * Looks for a category with the supplied name.
     * Inserts a new category if no match is found.
     *
     * @param categoryName the category name to find or save
     * @param categoryDao the DAO used to query and insert categories
     * @return the existing or newly inserted category
     */
    private static Category findOrCreateCategory(
            String categoryName,
            GenericDao<Category> categoryDao) {

        List<Category> existingCategories =
                categoryDao.getByPropertyEqual("category", categoryName);

        // Reuse the first matching category.
        if (!existingCategories.isEmpty()) {
            return existingCategories.get(0);
        }

        Category category = new Category();
        category.setCategory(categoryName);

        categoryDao.insert(category);

        return category;
    }

    /**
     * Inserts a relationship between a quote and a category
     * if that pair is not already stored.
     *
     * @param quote the quote to link
     * @param category the category to link
     * @param quoteCategoryDao the DAO used to query and insert relationships
     */
    private static void createRelationshipIfMissing(
            Quote quote,
            Category category,
            GenericDao<QuoteCategory> quoteCategoryDao) {

        // Check for a relationship matching both the quote and category.
        List<QuoteCategory> existingRelationships =
                quoteCategoryDao.getByTwoPropertiesEqual(
                        "quote", quote,
                        "category", category
                );

        if (!existingRelationships.isEmpty()) {
            return;
        }

        // Save the link between the quote and category.
        QuoteCategory quoteCategory = new QuoteCategory();
        quoteCategory.setQuote(quote);
        quoteCategory.setCategory(category);

        quoteCategoryDao.insert(quoteCategory);
    }
}