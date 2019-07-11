package com.engineering.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engineering.repository.UserRepository;
import com.engineering.controller.result.AverageWorkingTime;
import com.engineering.controller.result.Bonus;
import com.engineering.controller.result.Hours;
import com.engineering.controller.result.OverTime;
import com.engineering.model.User;
import com.engineering.model.dao.DaoClass;
import com.engineering.model.dto.UserDto;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private DaoClass daoClass;
	
	// DAO CUSTOM METHODS

	public AverageWorkingTime countAverageWorkingTimePerDayPerUser(int id){
		return daoClass.countAverageWorkingTimePerDayPerUser(id);
	}
	
	public List<Hours> getHoursPerDay(int id){
		return daoClass.getHoursPerDay(id);
	}
	
	public List<OverTime> getOverTimeWorkEmployees() {
		return daoClass.getOverTimeWorkEmployees();
	}
	
	public List<Bonus> getBonuForOverTimeWorkEmployees() {
		return daoClass.getBonusForOverTimeWorkEmployees();	
	}
	
	// C R U D
	
	public User findById(Integer id) {
		Optional<User> user = this.userRepo.findById(id);
		if(user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}
	
    public List<User> findAll() {
        return (List<User>) this.userRepo.findAll();
    }

    public User save(User user) {
        return this.userRepo.save(user);
    }
    
    public User update(Integer id, User user) {
    	user.setUserId(id);
    	return this.userRepo.save(user);
    	
    }
    
    public User updateSafe(int userId, UserDto userDto) {
        Optional<User> userOpt= userRepo.findById(userId);
        User user = new User();
        if(userOpt.isPresent()) {
            user = userOpt.get();
        } else {
        	// DJORDJIJE ERROR PAGE
            return null;
        }    
        user.setUserId(userId);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setRole(userDto.getRole());
        user.setPosition(userDto.getPosition());
        user.setEmail(userDto.getEmail());
        
        return userRepo.save(user);
    }
    
	public String deleteById(Integer id) {
		userRepo.deleteById(id);
		return "User removed!";
	}
    
	// GETTERS and SETTERS
	
	public DaoClass getDaoClass() {
		return daoClass;
	}
	
	public void setDaoClass(DaoClass daoClass) {
		this.daoClass = daoClass;
	}
	
	public User findByUsername(String username) {
        User user = userRepo.findByUsername(username);
       return user;
    }
	
/*	public User showCardReader() {	
		CardReader reader = new CardReader();		
		User user = daoClass.checkIfCardIsInserted(reader.R());
		
		return user;
	} */
	
}
