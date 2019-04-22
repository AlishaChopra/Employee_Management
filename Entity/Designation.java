package com.Employee.Employee.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="designation")
public class Designation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="designation_id")
	private int designationId;
	@Column(name="designation")
	private String designation;
	public Designation()
	{
		
	}
	public Designation(String designation) {
		super();
		this.designation = designation;
	}
	public int getDesignationId() {
		return designationId;
	}
	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
