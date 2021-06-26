package com.felipersumiya.domain;

import java.util.List;

public class Creator {
	
	
	private Integer available;
	private String creatorsUri;
	private List<Item> itens;
	
	public Creator() {
		
	}

	public Creator(Integer available, String creatorsUri, List<Item> itens) {
		super();
		this.available = available;
		this.creatorsUri = creatorsUri;
		this.itens = itens;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	public String getCreatorsUri() {
		return creatorsUri;
	}

	public void setCreatorsUri(String creatorsUri) {
		this.creatorsUri = creatorsUri;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	

}
