package controller;

import entity.Quote;
import org.json.JSONObject;
import persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Path("/quotes")
public class QuoteController {

    private final GenericDao<Quote> quoteDao = new GenericDao<>(Quote.class);

    @GET
    @Produces("application/json")
    public List<Quote> getAllQuotes() {
        return quoteDao.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuoteById(@PathParam("id") int id) {

        Quote quote = quoteDao.getById(id);

        if (quote == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Quote not found")
                    .build();
        }

        return Response.status(200)
                .entity(quote)
                .build();
    }

    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRandomQuote() {

        List<Quote> quote = quoteDao.getAll();

        if (quote == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("No quotes found")
                    .build();
        }

        int randomIndex = ThreadLocalRandom.current().nextInt(quote.size());

        Quote randomQuote = quote.get(randomIndex);

        return Response.status(200)
                .entity(randomQuote)
                .build();
    }
}
