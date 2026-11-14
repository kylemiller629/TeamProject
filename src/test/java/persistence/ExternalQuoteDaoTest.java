package persistence;

import entity.ExternalQuote;
import entity.Quote;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class ExternalQuoteDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Test successful connection
     * @throws Exception
     */
    @Test
    void testGetQuotes() throws Exception {

        String url = "https://api.api-ninjas.com/v2/randomquotes";
        String apiKey = System.getenv("API_NINJAS_KEY");

        assertNotNull(apiKey, "Set the API_NINJAS_KEY environment variable");

        ExternalQuoteDao dao = new ExternalQuoteDao(url, apiKey);

        ExternalQuote[] quotes = dao.getQuotes("success");

        assertNotNull(quotes);
        assertTrue(quotes.length > 0);
        assertNotNull(quotes[0].getQuote());

        logger.info("Quote: {}", quotes[0].getQuote());
        logger.info("Author: {}", quotes[0].getAuthor());
        logger.info("Categories: {}", quotes[0].getCategories());
    }

    /**
     * Tests if there's an invalid API key
     * @throws Exception exception
     */
    @Test
    void testInvalidApiKey() throws Exception {
        String url = "https://api.api-ninjas.com/v2/randomquotes";
        String invalidKey = "invalidApiKey";

        ExternalQuoteDao dao = new ExternalQuoteDao(url, invalidKey);

        ExternalQuote[] quotes = dao.getQuotes("success");

        assertNotNull(quotes);
        assertEquals(0, quotes.length);
        logger.info("Invalid API key test completed successfully.");
    }

}