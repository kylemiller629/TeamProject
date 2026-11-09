package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//TODO Add table and column names

@Entity
@Table(name = "")
/** Represents a Category in TeamProject
 * @author dweise
 */
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "")
    private int categoryId;

    @Column(name = "", nullable = false)
    private String category;

    @Column(name = "")
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<QuoteCategory> quoteCategory = new ArrayList<>();

    /**
     * Required by Hibernate.
     */
    public Category() {}

    /**
     * Creates a new Category
     *
     * @param category of quotes
     */
    public Category(String category) {
        this.category = category;
    }

    /** @return the category id */
    public int getCategoryId() {return categoryId;}

    /** @return the category */
    public String getCategory() {return category;}

    /** @param category Sets the category */
    public void setCategory(String category) {this.category = category;}

    /** @return the description */
    public String getDescription() {return description;}

    /** @param description Sets the description */
    public void setDescription(String description) {this.description = description;}

    /** @return the quote category */
    public List<QuoteCategory> getQuoteCategory() {return quoteCategory;}

    /** @param quoteCategory Sets the quote category */
    public void setQuoteCategory(List<QuoteCategory> quoteCategory) {this.quoteCategory = quoteCategory;}

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", quoteCategory=" + quoteCategory +
                '}';
    }
}
