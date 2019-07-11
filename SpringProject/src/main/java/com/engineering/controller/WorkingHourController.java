package com.engineering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.engineering.model.WorkingHour;
import com.engineering.service.WorkingHourService;

@RestController
@RequestMapping("/workinghour")
public class WorkingHourController {
	
	@Autowired
	WorkingHourService workingHourService;
	
	// CALLING SERVICE METHODS:
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping(value="/findall", method=RequestMethod.GET)
	public List<WorkingHour> findAll(){
		return workingHourService.findAll();
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping("/findbyid/{id}")
	public WorkingHour findById(@PathVariable int id){
		return workingHourService.findById(id);		
	}	
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping(value = "/save", method=RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody WorkingHour save(@RequestBody WorkingHour workingHour) {
		return workingHourService.save(workingHour);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@DeleteMapping(value = "/deletebyid/{id}")
	public String deleteById(@PathVariable int id) {
		return workingHourService.deleteById(id);
	}	
	
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@PutMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public WorkingHour updateWorkingHour(@PathVariable int id, @RequestBody WorkingHour workingHour) {
      return workingHourService.update(id, workingHour);
    } 	

/*  @Deprecated	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping(value = "/checkin", method=RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody WorkingHour checkIn(@RequestBody int userUserId) {
		return workingHourService.checkIn(userUserId);
	} */
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping(value="/checkinbycard", method=RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody WorkingHour checkInByCard(@RequestBody int userUserId){        
        return workingHourService.checkInByCard(userUserId);
    }
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@PutMapping(value = "/checkout", consumes = MediaType.APPLICATION_JSON_VALUE)
    public WorkingHour checkOut(@RequestBody int userUserId) throws Exception {
      return workingHourService.checkOut(userUserId);
    }
	
}
