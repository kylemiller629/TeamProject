package persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.ExternalQuote;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;


/**
 * DAO to connect to external API
 * @author kmiller
 */
public class ExternalQuoteDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private String url;
    private String apiKey;

    /**
     * Dao constructor lets us provide the API URL and key when creating DAO
     * @param url url path
     * @param apiKey api key
     */
    public ExternalQuoteDao(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
    }

    public ExternalQuote[] getQuotes(String category) {

        // create jersey client
        Client client = ClientBuilder.newClient();

        try {
            //build request url
            WebTarget target = client.target(url)
                    .queryParam("categories", category);

            //send the GET request
            String jsonResponse = target.request(MediaType.APPLICATION_JSON)
                    .header("X-Api-Key", apiKey)
                    .get(String.class);

            //convert JSON into java objects
            ObjectMapper mapper = new ObjectMapper();
            ExternalQuote[] quotes = mapper.readValue(jsonResponse, ExternalQuote[].class);

            //return external quotes
            return quotes;
        } catch (Exception e) {

            logger.error("External API request failed", e);

            return new ExternalQuote[0];
        } finally {
            client.close();
        }
    }
}
