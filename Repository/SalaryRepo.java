package com.Employee.Employee.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Employee.Entity.Salary;

public interface SalaryRepo extends CrudRepository<Salary,Integer> {
	
	public Salary findByEmpEmpId(int empId);
}
