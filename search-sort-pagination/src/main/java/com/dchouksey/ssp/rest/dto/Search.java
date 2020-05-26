package com.dchouksey.ssp.rest.dto;

import java.util.List;
import lombok.Data;

@Data
public class Search {
	
	private String key;
	private List<String> columns;

}
