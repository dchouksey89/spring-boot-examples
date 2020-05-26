package com.dchouksey.ssp.rest.dto;

import java.util.List;

import lombok.Data;

@Data
public class PaginationResponse {
	
	private int page;
	private int maxResults;
	private long size;
	private int totalPages;
	private boolean first;
	private boolean last;
	
	private List<Employee> employees;

}
