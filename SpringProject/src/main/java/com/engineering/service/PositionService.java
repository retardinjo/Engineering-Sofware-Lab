package com.engineering.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engineering.model.Position;
import com.engineering.repository.PositionRepository;

@Service
public class PositionService {
	
	@Autowired
	private PositionRepository positionRepo;

	// C R U D
	
	public Position findById(Integer id) {
		Optional<Position> position = this.positionRepo.findById(id);
		if(position.isPresent()) {
			return position.get();
		} else {
			// DJORDJIJE ERROR PAGE
			return null;
		}
	}
	
    public List<Position> findAll() {
        return (List<Position>) this.positionRepo.findAll();
    }

    public Position save(Position position) {
        return this.positionRepo.save(position);
    }
    
    public Position update(Integer id, Position position) {
    	position.setPositionId(id);
    	return this.positionRepo.save(position);
    	
    }
    
	public String deleteById(Integer id) {
		positionRepo.deleteById(id);
		return "Position removed!";
	}
	
}
