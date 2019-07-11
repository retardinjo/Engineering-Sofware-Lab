package com.engineering.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engineering.model.Salary;
import com.engineering.repository.SalaryRepository;

@Service
public class SalaryService {

	@Autowired
	private SalaryRepository salaryRepo;

	// C R U D

	public Salary findById(Integer id) {
		Optional<Salary> salary = this.salaryRepo.findById(id);
		if(salary.isPresent()) {
			return salary.get();
		} else {
			// DJORDJIJE ERROR PAGE
			return null;
		}
	}
	
    public List<Salary> findAll() {
        return (List<Salary>) this.salaryRepo.findAll();
    }

    public Salary save(Salary salary) {
        return this.salaryRepo.save(salary);
    }
    
    public Salary update(Integer id, Salary salary) {
    	salary.setSalaryId(id);
    	return this.salaryRepo.save(salary);
    	
    }
    
	public String deleteById(Integer id) {
		salaryRepo.deleteById(id);
		return "Salary removed!";
	}
	
}
