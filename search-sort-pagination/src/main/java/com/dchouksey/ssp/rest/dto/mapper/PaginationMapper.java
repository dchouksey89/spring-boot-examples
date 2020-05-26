package com.dchouksey.ssp.rest.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import com.dchouksey.ssp.jpa.entity.EmployeeEntity;
import com.dchouksey.ssp.rest.dto.Employee;
import com.dchouksey.ssp.rest.dto.PaginationResponse;


@Mapper(componentModel = "spring")
public interface PaginationMapper {
	
	default PaginationResponse toDtos(Page<EmployeeEntity> page) {
		
		PaginationResponse appPageResponse = new PaginationResponse();
		
		appPageResponse.setPage(page.getNumber());
		appPageResponse.setMaxResults(page.getSize());
		appPageResponse.setSize(page.getTotalElements());
		appPageResponse.setTotalPages(page.getTotalPages());
		appPageResponse.setFirst(page.isFirst());
		appPageResponse.setLast(page.isLast());
		
		List<EmployeeEntity> employeeEntities = page.toList();
		appPageResponse.setEmployees(toEmployeeDtos(employeeEntities));
		
		return appPageResponse;
	}
	
	List<Employee> toEmployeeDtos(List<EmployeeEntity> employeeEntities);
	
	

}
