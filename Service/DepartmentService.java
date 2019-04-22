package com.Employee.Employee.Service;

import java.util.List;

import com.Employee.Employee.Entity.Department;

public interface DepartmentService {
	void createDepartment(Department department);
	List<Department> getAllDepartment();
	Department updateDepartment(Department department, int id);
	void deleteDepartmentById(int id);
}
