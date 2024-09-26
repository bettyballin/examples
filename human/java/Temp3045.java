import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp3045 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/favicon.ico", "/resources/**", "/error").permitAll()
            .anyRequest().authenticated();
    }

    public static void main(String[] args) {
        // Spring Boot or other framework initialization code should go here
        System.out.println("Application started.");
    }
}