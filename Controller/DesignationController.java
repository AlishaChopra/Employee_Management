package com.Employee.Employee.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Employee.Entity.Designation;
import com.Employee.Employee.Repository.DesignationRepo;
import com.Employee.Employee.Service.DesignationService;

@RestController
public class DesignationController implements DesignationService {
	@Autowired
	private DesignationRepo designationRepo;
	
	@RequestMapping(method=RequestMethod.POST, value="/designation")
	public void createDesignation(@RequestBody Designation designation)
	{
		designationRepo.save(designation);
	}
	@RequestMapping("/designation")
	public List<Designation> getAllDesignation()
	{
		List<Designation> designationList = new ArrayList<Designation>();
		designationRepo.findAll().forEach(designationList::add);
		return designationList;
	}
	@RequestMapping(method=RequestMethod.PUT, value="/designation/{designationId}")
	public Designation updateDesignation(@RequestBody Designation designation, @PathVariable int designationId)
	{
		designation.setDesignationId(designationId);
		return designationRepo.save(designation);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/designation/{designationId}")
	public void deleteDesignationById(@PathVariable int designationId)
	{
		designationRepo.deleteById(designationId);
	}
}
