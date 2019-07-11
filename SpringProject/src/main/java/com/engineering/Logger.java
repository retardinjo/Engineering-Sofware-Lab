package com.engineering;

import java.io.FileWriter;
import java.io.IOException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import com.engineering.model.WorkingHour;

@Aspect
@Configuration
public class Logger {

	@AfterReturning(value = "execution(* com.engineering.controller.WorkingHourController.checkInByCard(..))", returning = "result")
    public void logCheckIn(JoinPoint joinPoint, WorkingHour result) throws IOException {
         
        FileWriter writer = new FileWriter("log.txt", true);
        writer.write((result).getUser().getUsername().toUpperCase());
        writer.write(" checked in at:  ");
        writer.write((result).getCheckInTime().toString());
        writer.write("\n");
        writer.close();
        
   }
		
   @AfterReturning(value = "execution(* com.engineering.controller.WorkingHourController.checkOut(..))", returning = "result")
   public void logCheckOut(JoinPoint joinPoint, WorkingHour result) throws IOException {
	   
       FileWriter writer = new FileWriter("log.txt",true);
       writer.write(((WorkingHour) result).getUser().getUsername().toUpperCase());
       writer.write(" checked out at:  ");
       writer.write(((WorkingHour) result).getCheckOutTime().toString());
       writer.write("\n");
       writer.close();
       
   }
   
}
