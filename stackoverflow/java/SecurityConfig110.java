// Assuming the code snippet is part of a class that extends WebSecurityConfig110urerAdapter

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig110urerAdapter;

@EnableWebSecurity
public class SecurityConfig110 extends WebSecurityConfig110urerAdapter {

    @Bean 
    @Override   
    public AuthenticationManager authenticationManagerBean() throws Exception {          
        return super.authenticationManagerBean();   
    } 
}