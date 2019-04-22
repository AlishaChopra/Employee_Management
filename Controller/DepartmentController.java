package com.Employee.Employee.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Employee.Entity.Department;
import com.Employee.Employee.Repository.DepartmentRepo;
import com.Employee.Employee.Service.DepartmentService;

@RestController
public class DepartmentController implements DepartmentService {
	@Autowired
	private DepartmentRepo departmentRepo;
	
	@RequestMapping("/department")
	public List<Department> getAllDepartment()
	{
		List<Department> data=new ArrayList<Department>();
		departmentRepo.findAll().forEach(data::add);
		return data;	
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/department")
	public void createDepartment(@RequestBody Department department)
	{
		departmentRepo.save(department);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/department/{id}")
	public void deleteDepartmentById(@PathVariable int id)
	{
		departmentRepo.deleteById(id);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/department/{id}")
	public Department updateDepartment(@RequestBody Department department, @PathVariable int id)
	{
		department.setDeptId(id);
		return departmentRepo.save(department);
	}
	
}
