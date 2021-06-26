package com.felipersumiya.domain;

public class Item {
	
	private String creatorUri;
	private String creatorName;
	private String role;
	
	
	public Item() {
		
	}


	public Item(String creatorUri, String creatorName, String role) {
		super();
		this.creatorUri = creatorUri;
		this.creatorName = creatorName;
		this.role = role;
	}


	public String getCreatorUri() {
		return creatorUri;
	}


	public void setCreatorUri(String creatorUri) {
		this.creatorUri = creatorUri;
	}


	public String getCreatorName() {
		return creatorName;
	}


	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	

}
