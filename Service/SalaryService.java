package com.Employee.Employee.Service;

import java.util.List;

import com.Employee.Employee.Entity.Salary;

public interface SalaryService  {
	void addSalary(int empId, Salary salary);
	List<Salary> getAllSalaries();
	Salary getSalaryByEmployeeId(int empId);
	Salary updateSalary(int empId, Salary salary, int salaryId);
	void deleteSalaryById(int id);
}
