package com.engineering.controller;
	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.engineering.controller.result.AverageWorkingTime;
import com.engineering.controller.result.Bonus;
import com.engineering.controller.result.Hours;
import com.engineering.controller.result.OverTime;
import com.engineering.model.User;
import com.engineering.security.EmployeePrincipal;
import com.engineering.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    UserService userService;
	
	// CALLING SERVICE METHODS:
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping("/gethours/{id}")
	public List<Hours> getHours(@PathVariable int id){
		return  userService.getHoursPerDay(id);	 
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping("/getaverage/{id}")
	public AverageWorkingTime getAverage(@PathVariable int id){
		return  userService.countAverageWorkingTimePerDayPerUser(id); 		 
	}

	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value="/overtimework", method=RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	public List<OverTime> getOverWorkEmployees(){
		return userService.getOverTimeWorkEmployees();		
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value="/overtimeworkbonus", method=RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	public List<Bonus> getBonusForOverWorkEmployees(){
		 return  userService.getBonuForOverTimeWorkEmployees();
	}
	
	@Secured({"ROLE_ADMIN"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping(value="/findall", method=RequestMethod.GET)
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping("/findbyid/{id}")
	public User findById(@PathVariable Integer id){
		return userService.findById(id);		
	}	
	
	@Secured({"ROLE_ADMIN"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping(value = "/save", method=RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody User save(@RequestBody User user) {
		return userService.save(user);
	}
	
	@Secured({"ROLE_ADMIN"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@DeleteMapping(value = "/deletebyid/{id}")
	public String deleteById(@PathVariable Integer id) {
		return userService.deleteById(id);
	}
	
	@Secured({"ROLE_ADMIN"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@PutMapping(value = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@PathVariable Integer id, @RequestBody User user) {
      return userService.update(id, user);
    }
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	public User findByUserName(String userName){
	   return userService.findByUsername(userName);        
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping("/findbyusername")
	public User findByUsername(@AuthenticationPrincipal UserDetails details){
	String username = details.getUsername();
	    return findByUserName(username);
	}
	
	@Secured({"ROLE_ADMIN"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@GetMapping(path = "/currentusers")
    public User getLoggedInEmployee() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof EmployeePrincipal) {
            EmployeePrincipal empPrincipal = (EmployeePrincipal) principal;
            return empPrincipal.getUser();
        }
        return null;
    }
	
/*	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping(value="/showcard", method=RequestMethod.GET)
	public User showCardReader(){		
		return userService.showCardReader();
	} */

}
