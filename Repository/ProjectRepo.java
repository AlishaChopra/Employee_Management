package com.Employee.Employee.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Employee.Employee.Entity.Project;

public interface ProjectRepo extends CrudRepository<Project,Integer> {

}
