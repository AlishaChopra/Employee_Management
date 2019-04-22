package com.Employee.Employee.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Employee.Entity.Salary;
import com.Employee.Employee.Entity.Emp;
import com.Employee.Employee.Repository.EmpRepo;
import com.Employee.Employee.Repository.SalaryRepo;

import com.Employee.Employee.Service.SalaryService;
@RestController
public class SalaryController implements SalaryService {
	@Autowired
	private SalaryRepo salaryRepo;
	@Autowired 
	private EmpRepo empRepo;
	
	@RequestMapping(method=RequestMethod.POST, value="emp/{empId}/salary")
	public void addSalary(@PathVariable int empId, @RequestBody Salary salary)
	{
		Emp emp = empRepo.findById(empId).get();
		salary.setEmp(emp);
		salaryRepo.save(salary);
		
		
	}
	@RequestMapping("/salary")
	public List<Salary> getAllSalaries()
	{
		List<Salary> salaryList = new ArrayList<Salary>();
		salaryRepo.findAll().forEach(salaryList::add);
		return salaryList;
	}
	@RequestMapping("emp/{empId}/salary")
	public Salary getSalaryByEmployeeId(@PathVariable int empId)
	{
		return salaryRepo.findByEmpEmpId(empId);
	}
	@RequestMapping(method=RequestMethod.PUT, value="emp/{empId}/salary/{salaryId}")
	public Salary updateSalary(@PathVariable int empId,@RequestBody Salary salary, @PathVariable int salaryId)
	{
		if(empRepo.existsById(empId))
		{
			Salary sal = salaryRepo.findById(salaryId).get();
			sal.setSalary(salary.getSalary());
			return salaryRepo.save(sal);
		}
		return salary;
	}
	@RequestMapping(method=RequestMethod.DELETE, value="emp/{empId}/salary/{salaryId}")
	public void deleteSalaryById(@PathVariable int salaryId)
	{
		salaryRepo.deleteById(salaryId);
	}
	
}
