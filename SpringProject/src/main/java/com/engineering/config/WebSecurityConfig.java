package com.engineering.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.engineering.security.EmployeeDetailService;


@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true , prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    
    @Autowired
    EmployeeDetailService detailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().and().authorizeRequests().anyRequest().authenticated().and().httpBasic().and().formLogin().defaultSuccessUrl("http://localhost:4200", true).permitAll()
        .and().logout().logoutUrl("/logout").invalidateHttpSession(true).deleteCookies("JSESSIONID");

    }
    
    @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
   }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(detailsService);
        return authProvider;
    }
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
     return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
    
}