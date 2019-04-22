package com.Employee.Employee.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Employee.Employee.Entity.Department;
import com.Employee.Employee.Entity.Designation;
import com.Employee.Employee.Entity.Emp;

public interface EmpRepo extends CrudRepository<Emp,Integer> {
	public List<Emp> findByDepartmentDeptIdAndDesignationDesignationId(int deptId, int designationId);

	public List<Emp> findByDepartmentDeptId(int deptId);

	public List<Emp> findByDesignationDesignationId(int designationId);

}
