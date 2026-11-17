package controller;

import entity.Quote;
import entity.QuoteCategory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import persistence.ExternalQuoteDao;

/**
 * REST controller for retrieving quotes from the database.
 * Supports retrieving all quotes, filtering by category,
 * finding quotes by ID, and selecting a random quote.
 *
 * @author Katie Schmidt
 */

@Path("/quotes")
public class QuoteController {

    private final GenericDao<Quote> quoteDao = new GenericDao<>(Quote.class);
    private final Logger logger = LogManager.getLogger(this.getClass());
    private final String apiKey = System.getenv("API_NINJAS_KEY");


    /**
     * Retrieves all quotes from the database.
     * If a category is provided, returns only quotes
     * that belong to that category.
     *
     * @param category optional category used to filter quotes
     * @return Response containing the list of quotes
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllQuotes(@QueryParam("category") String category) {

        try {
            List<Quote> quotes = quoteDao.getAll();
            if (category == null || category.isEmpty()) {
                return Response.status(200)
                        .entity(quotes)
                        .build();
            }

            List<Quote> filteredQuotes = new ArrayList<>();

            for (Quote quote : quotes) {
                for (QuoteCategory qc : quote.getQuoteCategory()) {

                    if (qc.getCategory().getCategory().equalsIgnoreCase(category)) {
                        filteredQuotes.add(quote);
                        break;
                    }
                }
            }

            return Response.status(200)
                    .entity(filteredQuotes)
                    .build();

        }catch (Exception e) {
            logger.error("Error retrieving quotes", e);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred while retrieving the quote")
                    .build();
        }
    }


    /**
     * Retrieves a quote from the database by its ID.
     *
     * @param id the ID of the quote to retrieve
     * @return Response containing the quote or an error message
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuoteById(@PathParam("id") int id) {

        try {
            Quote quote = quoteDao.getById(id);
            if (quote == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Quote not found")
                        .build();
            }

            return Response.status(200)
                    .entity(quote)
                    .build();

        } catch (Exception e) {
            logger.error("Error retrieving quote with ID: " + id, e);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred while retrieving the quote")
                    .build();
            }
    }

    /**
     * Retrieves a random quote from the database.
     *
     * @return Response containing a random quote or an error message
     */
    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRandomQuote() {

        try {
            List<Quote> quote = quoteDao.getAll();
            if (quote.isEmpty()) {
                return Response.status(404)
                        .entity("No quotes found")
                        .build();
            }

            int randomIndex = ThreadLocalRandom.current().nextInt(quote.size());

            Quote randomQuote = quote.get(randomIndex);

            return Response.status(200)
                    .entity(randomQuote)
                    .build();
        } catch (Exception e) {
            logger.error("Error retrieving random quote", e);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred while retrieving the quote")
                    .build();
        }
    }

    /** DAO used to communicate with the external quote API. */
    private final ExternalQuoteDao externalQuoteDao =
            new ExternalQuoteDao(
                    "https://api.api-ninjas.com/v2/quotes",
                    apiKey
            );
}
