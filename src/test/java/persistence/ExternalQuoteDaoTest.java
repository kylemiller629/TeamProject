package persistence;

import entity.ExternalQuote;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExternalQuoteDaoTest {

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

        System.out.println("Quote: " + quotes[0].getQuote());
        System.out.println("Author " + quotes[0].getAuthor());
        System.out.println("Categories " + quotes[0].getCategories());
    }

    @Test
    void testInvalidApiKey() throws Exception {
        String url = "https://api.api-ninjas.com/v2/randomquotes";
        String invalidKey = "invalidApiKey";

        ExternalQuoteDao dao = new ExternalQuoteDao(url, invalidKey);

        ExternalQuote[] quotes = dao.getQuotes("success");

        assertNotNull(quotes);
        assertEquals(0, quotes.length);
    }
}