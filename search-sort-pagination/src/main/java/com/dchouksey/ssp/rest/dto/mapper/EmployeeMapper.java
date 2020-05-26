package com.dchouksey.ssp.rest.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.dchouksey.ssp.jpa.entity.EmployeeEntity;
import com.dchouksey.ssp.rest.dto.Employee;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {
	
	Employee toDto(EmployeeEntity employeeEntity);
	
	EmployeeEntity toEntity(Employee employee);
	
	List<Employee> toDtos(List<EmployeeEntity> employeeEntities);
	
	List<EmployeeEntity> toEntities(List<Employee> employees);
	
	
	

}
