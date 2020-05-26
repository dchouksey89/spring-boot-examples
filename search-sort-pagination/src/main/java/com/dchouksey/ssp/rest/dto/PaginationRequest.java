package com.dchouksey.ssp.rest.dto;

import lombok.Data;

@Data
public class PaginationRequest {
	
	private int page;
	private int maxResults;
	private String sortBy;
	private String sortDirection;
	
	private Search search;

}
