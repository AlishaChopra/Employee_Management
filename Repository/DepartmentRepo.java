package com.Employee.Employee.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Employee.Employee.Entity.Department;
@Repository
public interface DepartmentRepo extends CrudRepository<Department,Integer> {

}
