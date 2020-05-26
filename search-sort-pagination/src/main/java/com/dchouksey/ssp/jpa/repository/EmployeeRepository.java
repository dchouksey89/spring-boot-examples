package com.dchouksey.ssp.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dchouksey.ssp.jpa.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>, JpaSpecificationExecutor<EmployeeEntity> {
	
	@Query("select e from EmployeeEntity e where CONCAT(lower(e.firstName), lower(e.lastName), e.age, lower(e.city), e.createdDate) like lower(concat('%', ?1, '%'))")          
	public Page<EmployeeEntity> findAll(String keyword, Pageable pageable);

}
