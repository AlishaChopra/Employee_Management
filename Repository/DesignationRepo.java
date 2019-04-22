package com.Employee.Employee.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Employee.Employee.Entity.Designation;

public interface DesignationRepo extends CrudRepository<Designation,Integer> {
	
}
