package com.Employee.Employee.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Employee.Employee.Entity.ProjectDetails;

public interface ProjectDetailsRepo extends CrudRepository<ProjectDetails,Integer> {
	List<ProjectDetails> findByEmpEmpId(int empId);
}
