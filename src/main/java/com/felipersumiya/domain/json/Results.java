package com.felipersumiya.domain.json;

import java.util.List;

public class Results {
	
	private Integer id;
	private Integer digitalId;
	private String title;
	private String isbn;
	private String description;
	private List<Prices> prices;
	private Creators creators;
	public Results() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDigitalId() {
		return digitalId;
	}

	public void setDigitalId(Integer digitalId) {
		this.digitalId = digitalId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Prices> getPrices() {
		return prices;
	}

	public void setPrices(List<Prices> prices) {
		this.prices = prices;
	}

	public Creators getCreators() {
		return creators;
	}

	public void setCreators(Creators creators) {
		this.creators = creators;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
}
