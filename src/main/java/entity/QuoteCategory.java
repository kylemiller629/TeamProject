package entity;

//TODO add table and column names

import jakarta.persistence.*;

@Entity
@Table(name = "")
/** Represents a Quotes Categories in TeamProject
 * @author dweise
 */
public class QuoteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "")
    private int quoteCategoryId;

    /** The quote category */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "", nullable = false)
    private Quote quote;

    /** The categories quote */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "", nullable = false)
    private Category category;

    /** Required by Hibernate. */
    public QuoteCategory() {}

    /**
     * Creates a new QuoteCategory.
     *
     * @param quote    the quote
     * @param category the category
     */
    public QuoteCategory(Quote quote, Category category) {
        this.quote = quote;
        this.category = category;
    }

    /** @return the quote category id */
    public int getQuoteCategoryId() {return quoteCategoryId;}

    /** @return the quote*/
    public Quote getQuote() {return quote;}

    /** @param quote Sets the quote */
    public void setQuote(Quote quote) {this.quote = quote;}

    /** @return the category */
    public Category getCategory() {return category;}

    /** @param category Sets the category */
    public void setCategory(Category category) {this.category = category;}

    @Override
    public String toString() {
        return "QuoteCategory{" +
                "quoteCategoryId=" + quoteCategoryId +
                ", quote=" + quote +
                ", category=" + category +
                '}';
    }
}
