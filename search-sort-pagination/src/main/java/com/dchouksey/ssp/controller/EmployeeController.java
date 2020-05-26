package com.dchouksey.ssp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dchouksey.ssp.rest.dto.Employee;
import com.dchouksey.ssp.rest.dto.PaginationRequest;
import com.dchouksey.ssp.rest.dto.PaginationResponse;
import com.dchouksey.ssp.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/rest")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(value = "/employee")
	public void save(@RequestBody Employee employee) {

		log.info("Calling save api for employee resourse.");
		employeeService.save(employee);

	}

	@GetMapping(value = "/employee/{id}")
	public Employee findById(@PathVariable Long id) {

		log.info("Calling findById api for employee resourse.");
		return employeeService.findById(id);

	}

	@DeleteMapping(value = "/employee/{id}")
	public void delete(@PathVariable Long id) {

		log.info("Calling delete api for employee resourse.");
		employeeService.delete(id);
	}

	@GetMapping(value = "/employee")
	public List<Employee> findAll() {

		log.info("Calling findAll api for employee resourse.");
		return employeeService.findAll();
	}
	

	@PostMapping(value = "/employee/search")
	public PaginationResponse findAll(@RequestBody PaginationRequest apppageRequest) {

		log.info("Calling findAll api for employee resourse."+apppageRequest.toString());
		
		return employeeService.findAll(apppageRequest);
	}

}
