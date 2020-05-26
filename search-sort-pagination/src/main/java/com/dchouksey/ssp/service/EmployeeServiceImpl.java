package com.dchouksey.ssp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dchouksey.ssp.jpa.entity.EmployeeEntity;
import com.dchouksey.ssp.jpa.repository.EmployeeRepository;
import com.dchouksey.ssp.rest.dto.Employee;
import com.dchouksey.ssp.rest.dto.PaginationRequest;
import com.dchouksey.ssp.rest.dto.PaginationResponse;
import com.dchouksey.ssp.rest.dto.mapper.EmployeeMapper;
import com.dchouksey.ssp.rest.dto.mapper.PaginationMapper;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	private PaginationMapper paginationMapper;

	@Override
	public void save(Employee employee) {
		
		EmployeeEntity employeeEntity = employeeMapper.toEntity(employee);
		employeeRepository.save(employeeEntity);
		
	}

	@Override
	public Employee findById(long id) {
		EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
		return employeeMapper.toDto(employeeEntity);
	}

	@Override
	public void delete(long id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public List<Employee> findAll() {
		List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
		return employeeMapper.toDtos(employeeEntities);
	}

	
	@Override
	public PaginationResponse findAll(PaginationRequest paginationRequest) {
		
		PageRequest pageRequest= null;
		
		if(paginationRequest.getSortBy() == null ) {
			pageRequest = PageRequest.of(paginationRequest.getPage()-1, paginationRequest.getMaxResults(), Sort.Direction.ASC, ("id"));
		}else {
			Sort sort = Sort.by(paginationRequest.getSortBy());
			sort = paginationRequest.getSortDirection().equals("asc") ? sort.ascending() : sort.descending();
			pageRequest = PageRequest.of(paginationRequest.getPage()-1, paginationRequest.getMaxResults(), sort);
		}
		
	
		Page<EmployeeEntity> page = employeeRepository.findAll(paginationRequest.getSearch().getKey(), pageRequest);
		return paginationMapper.toDtos(page);
	}
	
	

}
