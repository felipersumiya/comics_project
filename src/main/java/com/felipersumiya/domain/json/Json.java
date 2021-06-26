package com.felipersumiya.domain.json;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {

	private Integer code;
	private Integer status;
	private String copyright;
	private String attributionText;
	private String attributionHTML;
	private String etag;
	private List<String> data;
	
	ObjectMapper object = new ObjectMapper();
	
	public Json () {
		
		
	
	}

	public Json(Integer code, Integer status, String copyright, String attributionText, String attributionHTML,
			String etag, List<String> data) {
		super();
		this.code = code;
		this.status = status;
		this.copyright = copyright;
		this.attributionText = attributionText;
		this.attributionHTML = attributionHTML;
		this.etag = etag;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getAttributionText() {
		return attributionText;
	}

	public void setAttributionText(String attributionText) {
		this.attributionText = attributionText;
	}

	public String getAttributionHTML() {
		return attributionHTML;
	}

	public void setAttributionHTML(String attributionHTML) {
		this.attributionHTML = attributionHTML;
	}

	public String getEtag() {
		return etag;
	}

	public void setEtag(String etag) {
		this.etag = etag;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

	
}
