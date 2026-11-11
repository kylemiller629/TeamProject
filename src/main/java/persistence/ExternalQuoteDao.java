package persistence;

import entity.ExternalQuote;

public class ExternalQuoteDao {

    private String url;
    private String apiKey;

    /**
     * Dao constructor
     * @param url url path
     * @param apiKey api key
     */
    public ExternalQuoteDao(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
    }
}
