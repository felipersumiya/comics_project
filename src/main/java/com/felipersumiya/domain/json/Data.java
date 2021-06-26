package com.felipersumiya.domain.json;

import java.util.List;

public class Data {
	
	
	private Integer offset;
	private Integer limit;
	private Integer total;
	private Integer count;
	private List<Results> results;
	
	
	public Data() {
		
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
