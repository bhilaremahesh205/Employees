package com.mahesh.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.mahesh.demo.models.Employee;

public interface EmpRepository extends CrudRepository<Employee, String>{

	Employee findByEmpId(String empId);
	
	@Override
	public void delete(Employee employee);
	
}
