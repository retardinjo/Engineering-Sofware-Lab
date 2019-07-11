package com.engineering.service;

import java.util.List;
import java.util.Optional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engineering.cardReader.CardReader;
import com.engineering.model.User;
import com.engineering.model.WorkingHour;
import com.engineering.model.dao.DaoClass;
import com.engineering.repository.UserRepository;
import com.engineering.repository.WorkingHourRepository;

@Service
public class WorkingHourService {

	@Autowired
	private WorkingHourRepository workingHourRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private DaoClass daoClass;
	
	// C R U D:
	
	public WorkingHour findById(int id) {
		Optional<WorkingHour> workingHour = this.workingHourRepo.findById(id);
		if(workingHour.isPresent()) {
			return workingHour.get();
		} else {
			// DJORDJIJE ERROR PAGE
			return null;
		}
	}
	
    public List<WorkingHour> findAll() {
        return (List<WorkingHour>) this.workingHourRepo.findAll();
    }

    public WorkingHour save(WorkingHour workingHour) {
        return this.workingHourRepo.save(workingHour);
    }
      
    public WorkingHour update(int workingHourId, WorkingHour workingHour) {
    	workingHour.setWorkingHourId(workingHourId);
    	return this.workingHourRepo.save(workingHour);  	
    }	
    
	public String deleteById(int id) {
		workingHourRepo.deleteById(id);
		return "WorkingHour removed!";
	}
	
	// CHECK-IN, CHECK-IN BY CARD and CHECK-OUT

	
/*  @Deprecated
	@Transactional
    public WorkingHour checkIn(int userUserId) {
		Optional<User> user = userRepo.findById(userUserId);
	    if (user.get().getChecked() != false || !user.isPresent()) {
	           return null;
	    }
		
    	WorkingHour workingHour = new WorkingHour();
    	workingHour.setUser(user.get());
    	
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        Date now = new Date();          
        try {
			now = dateFormat.parse(dateFormat.format(now));
		} catch (ParseException e) {
			e.printStackTrace();
		}

        workingHour.setCheckInTime(now);

        user.get().setChecked(true);
        userRepo.save(user.get());
 	
        return this.workingHourRepo.save(workingHour);
    } */
	
	@Transactional
	public WorkingHour checkInByCard(int userUserId) {

		User user = daoClass.checkIdentity(userUserId, CardReader.getCardId());    
		
	    if (user.getChecked() != false) {
	    	// DJORDJIJE ERROR PAGE - USER ALREADY CHECKED
	    	return null;
	    }
		
    	WorkingHour workingHour = new WorkingHour();  
    	workingHour.setUser(user);

        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        Date now = new Date();          
        try {
			now = dateFormat.parse(dateFormat.format(now));
		} catch (ParseException e) {
			// DJORDJIJE ERROR PAGE - INVALID DATETIME FORMAT
			e.printStackTrace();
		}
        workingHour.setCheckInTime(now);

        user.setChecked(true);
        userRepo.save(user);
        
        return this.workingHourRepo.save(workingHour);
    }
   
    @Transactional
    public WorkingHour checkOut(int userUserId) throws Exception {
    	WorkingHour workingHour = daoClass.findWorkingHourByUserId(userUserId);
    	Optional<User> user = userRepo.findById(userUserId);
        if(workingHour == null || !user.isPresent()) {
        	// DJORDJIJE ERROR PAGE
            return null;
        }	    
	    
	    if (user.get().getChecked() != true) {
	    	// DJORDJIJE ERROR PAGE - USER IS NOT CHECKED
	    	return null;
	    }
    	
    	DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
	    Date now = new Date();
	    try {
	         now = dateFormat.parse(dateFormat.format(now));
	    } catch (ParseException e) {
	    	 // DJORDJIJE ERROR PAGE
	         e.printStackTrace();
	    }   	
	    
	    workingHour.setCheckOutTime(now);
	    
	    workingHour.getUser().setChecked(false);
	    userRepo.save(workingHour.getUser());
 	
    	return this.workingHourRepo.save(workingHour);  	
    }
	
}
