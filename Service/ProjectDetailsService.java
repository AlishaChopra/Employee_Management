package com.Employee.Employee.Service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.Employee.Employee.Entity.ProjectDetails;

public interface ProjectDetailsService {
	void addProjectDetails(int empId,int projectId, ProjectDetails detail);
	List<ProjectDetails> getDetailsByEmpId(int empId);

}
