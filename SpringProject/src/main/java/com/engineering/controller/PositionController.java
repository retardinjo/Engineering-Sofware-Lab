package com.engineering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.engineering.model.Position;
import com.engineering.service.PositionService;

@RestController
@RequestMapping("/position")
public class PositionController {
	
	@Autowired
	PositionService positionService;
	
	// CALLING SERVICE METHODS:
	
	@Secured({"ROLE_ADMIN"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping(value="/findall", method=RequestMethod.GET)
	public List<Position> findAll(){
		return positionService.findAll();
	}
	
	@Secured({"ROLE_ADMIN"})
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping("/findbyid/{id}")
	public Position findById(@PathVariable Integer id){
		return positionService.findById(id);		
	}	

	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@RequestMapping(value = "/save", method=RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public @ResponseBody Position save(@RequestBody Position position) {
		return positionService.save(position);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@DeleteMapping(value = "/deletebyid/{id}")
	public String deleteById(@PathVariable Integer id) {
		return positionService.deleteById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
	@PutMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Position updatePosition(@PathVariable Integer id, @RequestBody Position position) {
      return positionService.update(id, position);
    }
	
}
