package com.dchouksey.ssp.service;

import java.util.List;

import com.dchouksey.ssp.rest.dto.Employee;
import com.dchouksey.ssp.rest.dto.PaginationRequest;
import com.dchouksey.ssp.rest.dto.PaginationResponse;

public interface EmployeeService {

	public void save(Employee employee);

	public abstract Employee findById(long id);

	public abstract void delete(long id);

	public abstract List<Employee> findAll();
	
	public abstract PaginationResponse findAll(PaginationRequest paginationRequest);
	

}
