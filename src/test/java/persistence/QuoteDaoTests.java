package persistence;

import entity.Quote;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import static org.junit.jupiter.api.Assertions.*;

public class QuoteDaoTests {
    private GenericDao<Quote> quoteDao;

    @BeforeEach
    public void setUp() {
        quoteDao = new GenericDao<>(Quote.class);

        Database database = Database.getInstance();
        database.runSQL("CleanDB.sql");
    }

    @Test
    void getQuoteByIdSuccess() {
        Quote quote = quoteDao.getById(1);

        assertNotNull(quote);
        assertEquals("Small steps lead to big changes.", quote.getQuote());
    }

    @Test
    void insertQuoteSuccess() {
        String text = "A little progress is still progress";
        Quote quote = new Quote(text, null);

        int id = quoteDao.insert(quote);
        Quote savedQuote = quoteDao.getById(id);

        assertNotNull(savedQuote);
        assertEquals(text, savedQuote.getQuote());
    }

    @Test
    void updateQuoteSuccess() {
        Quote quote = quoteDao.getById(1);
        assertNotNull(quote);

        String updatedText = "Small steps still count.";
        quote.setQuote(updatedText);
        quoteDao.update(quote);

        Quote savedQuote = quoteDao.getById(1);
        assertNotNull(savedQuote);
        assertEquals(updatedText, savedQuote.getQuote());
    }

    @Test
    void deleteQuoteSuccess() {
        Quote quote = new Quote("A quote to delete", null);
        int id = quoteDao.insert(quote);

        quoteDao.delete(quote);

        assertNull(quoteDao.getById(id));
    }
}
