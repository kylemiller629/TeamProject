package persistence;

import entity.Quote;
import entity.Category;
import entity.QuoteCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the database operations for QuoteCategory.
 * @author kmiller
 */
public class QuoteCategoryDaoTests {

    private GenericDao<QuoteCategory> quoteCategoryDao;
    private GenericDao<Quote> quoteDao;
    private GenericDao<Category> categoryDao;

    /**
     * Resets the test database before each test.
     */
    @BeforeEach
    public void setUp() {
        Database database = Database.getInstance();
        database.runSQL("CleanDB.sql");

        quoteCategoryDao = new GenericDao<>(QuoteCategory.class);
        quoteDao = new GenericDao<>(Quote.class);
        categoryDao = new GenericDao<>(Category.class);
    }

    /**
     * Verifies that an existing quote-category relationship can be retrieved.
     */
    @Test
    void getQuoteCategoryByIdSuccess() {
        QuoteCategory quoteCategory = quoteCategoryDao.getById(1);

        assertNotNull(quoteCategory);
        assertEquals(1, quoteCategory.getQuote().getQuoteId());
        assertEquals("Motivation", quoteCategory.getCategory().getCategory());
    }

    /**
     *  Verifies that all sample relationships are retrieved.
     */
    @Test
    void getAllQuoteCategoriesSuccess() {
        List<QuoteCategory> quoteCategories = quoteCategoryDao.getAll();

        assertNotNull(quoteCategories);
        assertEquals(4, quoteCategories.size());
    }

    /**
     * Verifies that a new quote-category relationship can be inserted.
     */
    @Test
    void insertQuoteCategorySuccess() {
        Quote quote = quoteDao.getById(2);
        Category category = categoryDao.getById(1);

        assertNotNull(quote);
        assertNotNull(category);

        QuoteCategory quoteCategory = new QuoteCategory(quote, category);

        int id = quoteCategoryDao.insert(quoteCategory);
        QuoteCategory saved = quoteCategoryDao.getById(id);

        assertNotNull(saved);
        assertEquals(2, saved.getQuote().getQuoteId());
        assertEquals("Motivation", saved.getCategory().getCategory());
    }

    /**
     * Verifies that a relationship can be updated.
     */
    @Test
    void updateQuoteCategorySuccess() {
        QuoteCategory quoteCategory = quoteCategoryDao.getById(4);
        Category category = categoryDao.getById(2);

        assertNotNull(quoteCategory);
        assertNotNull(category);

        quoteCategory.setCategory(category);
        quoteCategoryDao.update(quoteCategory);

        QuoteCategory saved = quoteCategoryDao.getById(4);

        assertNotNull(saved);
        assertEquals("Success", saved.getCategory().getCategory());
    }

    /**
     * Verifies that a quote-category relationship can be deleted.
     */
    @Test
    void deleteQuoteCategorySuccess() {
        QuoteCategory quoteCategory = quoteCategoryDao.getById(4);

        assertNotNull(quoteCategory);

        quoteCategoryDao.delete(quoteCategory);

        assertNull(quoteCategoryDao.getById(4));
    }
}
