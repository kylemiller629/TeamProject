package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExternalQuote {

	@JsonProperty("quote")
	private String quote;

	@JsonProperty("author")
	private String author;

	@JsonProperty("work")
	private String work;

	@JsonProperty("category")
	private String category;

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

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}
}