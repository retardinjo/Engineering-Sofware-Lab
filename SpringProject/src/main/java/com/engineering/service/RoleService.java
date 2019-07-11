package com.engineering.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engineering.model.Role;
import com.engineering.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepo;

	// C R U D
	
	public Role findById(Integer id) {
		Optional<Role> role = this.roleRepo.findById(id);
		if(role.isPresent()) {
			return role.get();
		} else {
			// DJORDJIJE ERROR PAGE
			return null;
		}
	}
	
    public List<Role> findAll() {
        return (List<Role>) this.roleRepo.findAll();
    }

    public Role save(Role role) {
        return this.roleRepo.save(role);
    }
    
    public Role update(Integer id, Role role) {
    	role.setRoleId(id);
    	return this.roleRepo.save(role);
    	
    }
    
	public String deleteById(Integer id) {
		roleRepo.deleteById(id);
		return "Role removed!";
	}	

    public Role findByRoleName(String roleName) {
        Role role = roleRepo.findByRoleName(roleName);
        return role;
    }
    
}
