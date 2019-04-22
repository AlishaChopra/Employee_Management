package com.Employee.Employee.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Employee.Entity.Emp;
import com.Employee.Employee.Entity.Project;
import com.Employee.Employee.Entity.ProjectDetails;
import com.Employee.Employee.Repository.EmpRepo;
import com.Employee.Employee.Repository.ProjectDetailsRepo;
import com.Employee.Employee.Repository.ProjectRepo;

@RestController
public class ProjectDetailsController {
	@Autowired
	private ProjectRepo projectRepo;
	@Autowired
	private EmpRepo empRepo;
	@Autowired
	private ProjectDetailsRepo detailsRepo;
	
	@RequestMapping(method=RequestMethod.POST,value="emp/{empId}/project/{projectId}/details")
	public void addProjectDetails(@PathVariable int empId, @PathVariable int projectId, @RequestBody ProjectDetails details) 
	{
		Emp emp = empRepo.findById(empId).get();
		details.setEmp(emp);
		Project project = projectRepo.findById(projectId).get();
		details.setProject(project);
		detailsRepo.save(details);
	}
	@RequestMapping("emp/{empId}/details")
	public List<ProjectDetails> getDetailsByEmpId(@PathVariable int empId)
	{
		List<ProjectDetails> detailList=new ArrayList<ProjectDetails>();
		detailsRepo.findByEmpEmpId(empId).forEach(detailList::add);
		return detailList;
	}
}
