package com.Employee.Employee.Service;

import java.util.List;

import com.Employee.Employee.Entity.Project;



public interface ProjectService {
	void addProject(Project project);
	List<Project> getAllProjects();
	Project updateProject(Project project, int projectId);
	void deleteProjectById(int projectId);
}
