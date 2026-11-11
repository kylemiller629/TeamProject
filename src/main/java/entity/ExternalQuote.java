package entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExternalQuote {

	@JsonProperty("quote")
	private String quote;

	@JsonProperty("author")
	private String author;

	@JsonProperty("work")
	private String work;

	@JsonProperty("categories")
	private List<String> categories;

	public void setQuote(String quote){
		this.quote = quote;
	}

	public String getQuote(){
		return quote;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setWork(String work){
		this.work = work;
	}

	public String getWork(){
		return work;
	}

	public void setCategories(List<String> categories){
		this.categories = categories;
	}

	public List<String> getCategories(){
		return categories;
	}
}