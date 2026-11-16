package persistence;

import entity.ExternalQuote;


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
    void testGetQuote() throws Exception {

        String url = "https://api.api-ninjas.com/v2/randomquotes";
        String apiKey = System.getenv("API_NINJAS_KEY");

        assertNotNull(apiKey, "Set the API_NINJAS_KEY environment variable");

        ExternalQuoteDao dao = new ExternalQuoteDao(url, apiKey);

        ExternalQuote quote = dao.getQuote();

        assertNotNull(quote);
        assertNotNull(quote.getQuote());
        assertNotNull(quote.getAuthor());
        assertNotNull(quote.getCategories());
        assertFalse(quote.getCategories().isEmpty());

        logger.info("Quote: {}", quote.getQuote());
        logger.info("Author: {}", quote.getAuthor());
        logger.info("Categories: {}", quote.getCategories());
    }

    /**
     * Tests if there's an invalid API key
     */
    @Test
    void testInvalidApiKey() {
        String url = "https://api.api-ninjas.com/v2/randomquotes";
        String invalidKey = "invalidApiKey";

        ExternalQuoteDao dao = new ExternalQuoteDao(url, invalidKey);

        ExternalQuote quote = dao.getQuote();


        assertNull(quote);
        logger.info("Invalid API key test completed successfully.");
    }

}