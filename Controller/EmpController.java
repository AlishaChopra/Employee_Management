package com.Employee.Employee.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Employee.Entity.Department;
import com.Employee.Employee.Entity.Designation;
import com.Employee.Employee.Entity.Emp;
import com.Employee.Employee.Repository.DepartmentRepo;
import com.Employee.Employee.Repository.DesignationRepo;
import com.Employee.Employee.Repository.EmpRepo;
import com.Employee.Employee.Service.EmpService;
@RestController
public class EmpController implements EmpService {

	@Autowired
	private DesignationRepo designationRepo;
	@Autowired
	private DepartmentRepo deptRepo;
	@Autowired
	private EmpRepo empRepo;
	
	@RequestMapping(method=RequestMethod.POST,value="/department/{deptId}/designation/{designationId}/employee")
	public void createEmpDetails(@RequestBody Emp emp, @PathVariable int designationId, @PathVariable int deptId)
	{
		Department dept = deptRepo.findById(deptId).get();
		emp.setDepartment(dept);
		Designation designation = designationRepo.findById(designationId).get();
		emp.setDesignation(designation);
		empRepo.save(emp);	
	}
	@RequestMapping("/department/{deptId}/designation/{designationId}/employee")
	public List<Emp> getEmployeeByDeptIdDesignationId(@PathVariable int designationId,@PathVariable int deptId)
	{
		List<Emp> empDetails = new ArrayList<Emp>();
		empRepo.findByDepartmentDeptIdAndDesignationDesignationId(deptId, designationId).forEach(empDetails::add);
		return empDetails;
	}
	@RequestMapping("/department/{deptId}/employee")
	public List<Emp> getEmployeeByDeptId(@PathVariable int deptId)
	{
		List<Emp> empDetails = new ArrayList<Emp>();
		empRepo.findByDepartmentDeptId(deptId).forEach(empDetails::add);
		return empDetails;
	}
	@RequestMapping("/designation/{designationId}/employee")
	public List<Emp> getEmployeeByDesignationId(@PathVariable int designationId)
	{
		List<Emp> empDetails = new ArrayList<Emp>();
		empRepo.findByDesignationDesignationId(designationId).forEach(empDetails::add);
		return empDetails;
	}
	@RequestMapping(method=RequestMethod.PUT,value="/department/{deptId}/employee/{id}")
	public Emp updateEmployeeDetailsByDepartmentId(@PathVariable int deptId, @RequestBody Emp emp, @PathVariable int id)
	{
		if(deptRepo.existsById(deptId))
		{
			Emp emp1 = empRepo.findById(id).get();
			emp1.setContact(emp.getContact());
			emp1.setEmpName(emp.getEmpName());
			return empRepo.save(emp1);
		}
		return emp;
	}
}
