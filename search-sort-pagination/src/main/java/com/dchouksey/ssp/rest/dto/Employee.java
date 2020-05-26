package com.dchouksey.ssp.rest.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Employee {
	
	private long id;
	private String firstName;
	private String lastName;
	private int age;
	private int salary;
	private String city;
	
	private Date createdDate;

}
