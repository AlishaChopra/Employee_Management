package com.Employee.Employee.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="project_details")
public class ProjectDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="project_detail_id")
	private int projectDetailId;
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Emp emp;
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	@Column(name="deliverable_date")
	private String date;
	public ProjectDetails(){}
	
	public ProjectDetails(String date) {
		super();
		this.date = date;
	}

	public int getProjectDetailId() {
		return projectDetailId;
	}
	
	public void setProjectDetailId(int projectDetailId) {
		this.projectDetailId = projectDetailId;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
