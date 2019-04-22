package com.Employee.Employee.Service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.Employee.Employee.Entity.Emp;

public interface EmpService {
	void createEmpDetails(Emp emp, int designationId, int deptId);
	List<Emp> getEmployeeByDeptIdDesignationId(int designationId, int deptId);
	Emp updateEmployeeDetailsByDepartmentId(int deptId, Emp emp, int id);
	List<Emp> getEmployeeByDeptId(int deptId);
	List<Emp> getEmployeeByDesignationId(int designationId);
	
}
