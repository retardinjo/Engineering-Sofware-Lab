package com.engineering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.engineering.model.Salary;
import com.engineering.service.SalaryService;

@RestController
@RequestMapping("/salary")
public class SalaryController {

	@Autowired
	SalaryService salaryService;
		
	// CALLING SERVICE METHODS:
	
	@Secured({"ROLE_ADMIN"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping(value="/findall", method=RequestMethod.GET)
	public List<Salary> findAll(){
		return salaryService.findAll();
	}
	
	@Secured({"ROLE_ADMIN"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping("/findbyid/{id}")
	public Salary findById(@PathVariable Integer id){
		return salaryService.findById(id);		
	}	

	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping(value = "/save", method=RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody Salary save(@RequestBody Salary salary) {
		return salaryService.save(salary);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@DeleteMapping(value = "/deletebyid/{id}")
	public String deleteById(@PathVariable Integer id) {
		return salaryService.deleteById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@PutMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Salary updateSalary(@PathVariable Integer id, @RequestBody Salary salary) {
      return salaryService.update(id, salary);
    }
	
}
