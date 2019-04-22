package com.Employee.Employee.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Employee.Entity.Designation;
import com.Employee.Employee.Entity.Project;
import com.Employee.Employee.Repository.ProjectRepo;
import com.Employee.Employee.Service.ProjectService;


@RestController
public class ProjectController implements ProjectService {
	@Autowired
	private ProjectRepo projectRepo;
	
	@RequestMapping(method=RequestMethod.POST, value="/project")
	public void addProject(@RequestBody Project project)
	{
		projectRepo.save(project);
	}
	@RequestMapping("/project")
	public List<Project> getAllProjects()
	{
		List<Project> projectList = new ArrayList<Project>();
		projectRepo.findAll().forEach(projectList::add);
		return projectList;
	}
	@RequestMapping(method=RequestMethod.PUT, value="/project/{projectId}")
	public Project updateProject(@RequestBody Project project, @PathVariable int projectId)
	{
		project.setProjectId(projectId);
		return projectRepo.save(project);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/project/{projectId}")
	public void deleteProjectById(@PathVariable int projectId)
	{
		projectRepo.deleteById(projectId);
	}
}
