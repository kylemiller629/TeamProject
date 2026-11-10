package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quotes")
/** Represents a Quote in TeamProject
 * @author dweise
 */
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quote_id")
    private int quoteId;

    @Column(name = "quote", nullable = false)
    private String quote;

    @Column(name = "author")
    private String author;

    @OneToMany(mappedBy = "quote", fetch = FetchType.EAGER)
    private List<QuoteCategory> quoteCategory = new ArrayList<>();

    /** Required by Hibernate. */
    public Quote() {}

    /** Creates a new Quote
     * @param quote the quote
     * @param author author of the quote
     */
    public Quote(String quote, String author) {
        this.quote = quote;
        this.author = author;
    }

    /** @return the quote id */
    public int getQuoteId() {return quoteId;}

    /** @return the quote */
    public String getQuote() {return quote;}

    /** @param quote Sets the quote */
    public void setQuote(String quote) {this.quote = quote;}

    /** @return the author */
    public String getAuthor() {return author;}

    /** @param author Sets the author */
    public void setAuthor(String author) {this.author = author;}

    /** @return the quote categories*/
    public List<QuoteCategory> getQuoteCategory(){return quoteCategory;}

    @Override
    public String toString() {
        return "Quote{" +
                "quoteId=" + quoteId +
                ", quote='" + quote + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
