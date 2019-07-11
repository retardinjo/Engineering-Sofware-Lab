package com.engineering.security;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.engineering.model.User;
import com.engineering.repository.UserRepository;


@Service
public class EmployeeDetailService implements UserDetailsService {


   @Autowired
   UserRepository userRepo;

   @Override
   public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

       User user = userRepo.findByUsername(userName);
       if (user == null) {
           throw new UsernameNotFoundException(userName);
       }
       return new EmployeePrincipal(user);
   }
}
