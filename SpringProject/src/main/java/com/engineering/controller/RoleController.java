package com.engineering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.engineering.model.Role;
import com.engineering.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	RoleService roleService;	
	
	// CALLING SERVICE METHODS:
	
	@Secured({"ROLE_ADMIN"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping(value="/findall", method=RequestMethod.GET)
	public List<Role> findAll(){
		return roleService.findAll();
	}
	
	@Secured({"ROLE_ADMIN"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping("/findbyid/{id}")
	public Role findById(@PathVariable Integer id){
		return roleService.findById(id);		
	}	

	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping(value = "/save", method=RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody Role save(@RequestBody Role role) {
		return roleService.save(role);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@DeleteMapping(value = "/deletebyid/{id}")
	public String deleteById(@PathVariable Integer id) {
		return roleService.deleteById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@PutMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Role updateRole(@PathVariable Integer id, @RequestBody Role role) {
        return roleService.update(id, role);
    }
	
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping("/findbyrolename/{roleName}")
	    public Role findByRoleName(@PathVariable String roleName){
	    return roleService.findByRoleName(roleName);        
	}
	
}
