package com.felipersumiya.domain.json;

import java.util.List;

//objeto principa do Json
public class ComicJson {
	
	private String code;
	private String id;
	private String title;
	private String isbn;//necessário
	private String description;
	private String etag;
	private Integer offset;
	private Data data;
	
	

	public ComicJson() {
				
	}

	public Integer getOffset() {
		return offset;
	}


	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	
	public String getEtag() {
		return etag;
	}


	
	
	public Data getData() {
		return data;
	}


	public void setData(Data data) {
		this.data = data;
	}


	public void setEtag(String etag) {
		this.etag = etag;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
