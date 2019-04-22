package com.Employee.Employee.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="salary")
public class Salary {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="salary_id")
	private int salaryId;
	@Column(name="salary")
	private float salary;
	@OneToOne
	@JoinColumn(name="emp_id")
	private Emp emp;
	
	public Salary(){}
	public Salary(float salary) {
		super();
		this.salary = salary;
	}
	public int getSalaryId() {
		return salaryId;
	}
	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
	
}
