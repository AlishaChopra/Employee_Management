package com.Employee.Employee.Service;

import java.util.List;


import com.Employee.Employee.Entity.Designation;

public interface DesignationService {
	void createDesignation(Designation designation);
	List<Designation> getAllDesignation();
	Designation updateDesignation(Designation designation, int designation_id);
	void deleteDesignationById(int designation_id);
}
