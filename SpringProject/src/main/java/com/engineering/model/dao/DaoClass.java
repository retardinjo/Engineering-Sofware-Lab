package com.engineering.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.engineering.controller.result.AverageWorkingTime;
import com.engineering.controller.result.Bonus;
import com.engineering.controller.result.Hours;
import com.engineering.controller.result.OverTime;
import com.engineering.model.User;
import com.engineering.model.WorkingHour;
import com.engineering.repository.PositionRepository;
import com.engineering.repository.RoleRepository;
import com.engineering.repository.SalaryRepository;
import com.engineering.repository.UserRepository;
import com.engineering.repository.WorkingHourRepository;

@Component("daoClass")
public class DaoClass {
	
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	WorkingHourRepository workingHourRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	SalaryRepository salaryRepo;
	
	@Autowired
	PositionRepository positionRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
    
    @Autowired
    public void setDataSource(DataSource ds) {
        this.jdbc = new NamedParameterJdbcTemplate(ds);
    }
    
    // CUSTOM DAO METHODS
    
	public AverageWorkingTime countAverageWorkingTimePerDayPerUser(int id) {		
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);        
        
        return jdbc.queryForObject("SELECT u.FIRST_NAME || ' ' || u.LAST_NAME AS full_Name,\r\n" + 
        		"concat(FLOOR(AVG((w.check_out_time  - w.check_in_time)*24*60)/60) || 'h:' ||\r\n" + 
        		"ROUND((100*(AVG((w.check_out_time - w.check_in_time)*24*60)/60 - trunc(AVG((w.check_out_time - w.check_in_time)*24*60)/60)))*60/100),'m') as avg_time\r\n" + 
        		"FROM WORKING_HOUR_TABLE w\r\n" + 
        		"JOIN USER_TABLE u ON u.user_id = w.user_user_id\r\n" + 
        		"WHERE w.USER_USER_ID=:id\r\n" + 
        		"GROUP BY u.FIRST_NAME, u.LAST_NAME"
        		, params, new RowMapper<AverageWorkingTime>() {
            
        public AverageWorkingTime mapRow(ResultSet rs, int rowNum) throws SQLException {
      	
        		AverageWorkingTime average = new AverageWorkingTime();
        		
        		average.setFullName(rs.getString("full_Name"));
        		average.setAvg(rs.getString("avg_time"));            	
            	
            	return average;
                         
            }        
        });   
    }
	
	public List<Hours> getHoursPerDay(int id) {
		 MapSqlParameterSource params = new MapSqlParameterSource();

	        params.addValue("id", id);
	        
	        return jdbc.query("SELECT u.FIRST_NAME || ' ' || u.LAST_NAME as full_Name, TO_CHAR(w.check_in_time,'DD-MM-YYYY') AS date_of ,\r\n" + 
	        		"concat(FLOOR((SUM((w.check_out_time - w.check_in_time)*24*60)/60)) || 'h:' ||\r\n" + 
	        		"ROUND((100*(SUM((w.check_out_time - w.check_in_time)*24*60)/60 - trunc(SUM((w.check_out_time - w.check_in_time)*24*60)/60)))*60/100),'m')  as hours_per_day\r\n" + 
	        		"FROM WORKING_HOUR_TABLE w\r\n" + 
	        		"JOIN USER_TABLE u on u.USER_ID = w.USER_USER_ID\r\n" + 
	        		"WHERE w.USER_USER_ID =:id  AND (TO_CHAR(w.check_in_time,'DD-MM-YYYY') = TO_CHAR(w.check_out_time,'DD-MM-YYYY'))\r\n" + 
	        		"GROUP BY u.FIRST_NAME, u.LAST_NAME, TO_CHAR(w.check_in_time,'DD-MM-YYYY')"
	        		, params, new RowMapper<Hours>() {
	            public Hours mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	
	            	Hours hours = new Hours();
	            	
	            	hours.setHoursPerDay(rs.getString("hours_per_day"));
	            	hours.setFullName(rs.getString("full_Name"));
	            	hours.setDay(rs.getString("date_of"));
	            	
	            	return hours;
	            }              
	        });  
	}
	
	
	public List<OverTime> getOverTimeWorkEmployees() {	

	        return jdbc.query("SELECT u.FIRST_NAME || ' ' || u.LAST_NAME as full_Name,TO_CHAR(w.check_in_time,'DD-MM-YYYY') AS date_of,\r\n" + 
	        		"concat(FLOOR((SUM((w.check_out_time - w.check_in_time)*24*60)/60 -8))|| 'h:' ||\r\n" + 
	        		"ROUND((100*(SUM((w.check_out_time - w.check_in_time)*24*60)/60 - trunc(SUM((w.check_out_time - w.check_in_time)*24*60)/60)))*60/100),'m') as over_time_work\r\n" + 
	        		"FROM WORKING_HOUR_TABLE w\r\n" + 
	        		"JOIN USER_TABLE u ON u.user_id = w.user_user_id\r\n" + 
	        		"WHERE (TO_CHAR(w.check_in_time,'DD-MM-YYYY') = TO_CHAR(w.check_out_time,'DD-MM-YYYY'))\r\n" + 
	        		"GROUP BY u.first_name, u.last_name, TO_CHAR(w.check_in_time,'DD-MM-YYYY')\r\n" + 
	        		"HAVING SUM((w.check_out_time - w.check_in_time)*24*60) > 480"
	        		, new RowMapper<OverTime>() {
	        	
	            public OverTime mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	
	            	OverTime employee = new OverTime();
            	
	            	employee.setFullName(rs.getString("full_Name"));
	            	employee.setDate(rs.getString("date_of"));
	            	employee.setOverTimeWork(rs.getString("over_time_work"));
	            	            	
	            	return employee;	                    	
	            }   	            
	        });          
	}
       
	public List<Bonus> getBonusForOverTimeWorkEmployees() {		 
	        
		return jdbc.query("SELECT u.FIRST_NAME || ' ' || u.LAST_NAME AS full_Name, TO_CHAR(w.check_in_time,'DD-MM-YYYY') AS date_of,\r\n" + 
				"concat(FLOOR((SUM((w.check_out_time - w.check_in_time)*24*60)/60 -8))|| 'h:' ||\r\n" + 
				"ROUND((100*(SUM((w.check_out_time - w.check_in_time)*24*60)/60 - trunc(SUM((w.check_out_time - w.check_in_time)*24*60)/60)))*60/100),'m') as over_time_work,\r\n" + 
				"concat(ROUND((SUM((w.check_out_time - w.check_in_time)*24*60)/60 -8) * 10,2), ' €') AS bonus_per_day\r\n" + 
				"FROM WORKING_HOUR_TABLE w\r\n" + 
				"JOIN USER_TABLE u ON u.user_id = w.user_user_id\r\n" + 
				"WHERE (TO_CHAR(w.check_in_time,'DD-MM-YYYY')= TO_CHAR(w.check_out_time,'DD-MM-YYYY'))\r\n" + 
				"GROUP BY u.first_name, u.last_name, TO_CHAR(w.check_in_time,'DD-MM-YYYY')\r\n" + 
				"HAVING SUM((w.check_out_time - w.check_in_time)*24*60) > 480"
	        		, new RowMapper<Bonus>() {
	        	
	            public Bonus mapRow(ResultSet rs, int rowNum) throws SQLException {
	            	
	            	Bonus bonus  = new Bonus();
	            	
	            	bonus.setFullName(rs.getString("full_Name"));
	            	bonus.setMonth(rs.getString("date_of"));
	            	bonus.setBonus(rs.getString("bonus_per_day"));
	            	
	            	return bonus;            	
	            }   	            
	        });  
	}

	public WorkingHour findWorkingHourByUserId(int userUserId) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", userUserId);
        return jdbc.queryForObject("SELECT * FROM WORKING_HOUR_TABLE WHERE USER_USER_ID=:id ORDER BY WORKING_HOUR_ID DESC FETCH FIRST 1 ROWS ONLY", params, new RowMapper<WorkingHour>() {

            public WorkingHour mapRow(ResultSet rs, int rowNum) throws SQLException {
            	
                Optional<WorkingHour> workingHourOpt = workingHourRepo.findById(rs.getInt("working_hour_id"));
                
                if(!workingHourOpt.isPresent()) {
                	// DJORDJIJE ERROR PAGE 
                	return null;
                }
                
                WorkingHour workingHour = workingHourOpt.get();
            
                return workingHour;

            }
        });
    }
	
	public User checkIdentity(int userUserId, String cardId) {
       	
		MapSqlParameterSource params = new MapSqlParameterSource();
		   params.addValue("user", userUserId);
	       params.addValue("card", cardId);
	       
	        return jdbc.queryForObject("SELECT * FROM USER_TABLE WHERE USER_ID=:user AND CARD_ID=:card", params, new RowMapper<User>() {

	            public User mapRow(ResultSet rs, int rowNum) throws SQLException {

	                Optional<User> user = userRepo.findById(userUserId);
	                
	        		if (!user.isPresent()) {
	        			// DJORDJIJE ERROR PAGE
	        			return null;
	        		}

	                return user.get();
	        }
	     });
	}
		
/*	public User checkIfCardIsInserted(String cardId) {
    	MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("cardId", cardId);
		return jdbc.queryForObject("SELECT * FROM USER_TABLE WHERE CARD_ID=:cardId", params, new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserId(rs.getInt("USER_ID"));
				user.setChecked(rs.getBoolean("CHECKED"));
				user.setEmail(rs.getString("EMAIL"));
				user.setFirstName(rs.getString("FIRST_NAME"));
				user.setLastName(rs.getString("LAST_NAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				user.setPosition(positionRepo.findById(rs.getInt("POSITION_POSITION_ID")).get());
				user.setRole(roleRepo.findById(rs.getInt("ROLE_ROLE_ID")).get());
				user.setCardId(rs.getString("CARD_ID"));
				user.setUsername(rs.getString("USERNAME"));		
				return user;
			}
		});
    } */

}
