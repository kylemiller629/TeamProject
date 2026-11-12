package controller;

import entity.Quote;
import persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/quotes")
public class QuoteController {

    private final GenericDao<Quote> quoteDao = new GenericDao<>(Quote.class);

    @GET
    @Produces("application/json")
    public List<Quote> getAllQuotes() {
        return quoteDao.getAll();
    }
}
