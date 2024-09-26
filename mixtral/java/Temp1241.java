import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1241 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // Main method can be used to launch a Spring Boot application
        // SpringApplication.run(Temp1241.class, args);
        System.out.println("Application started");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/createaccount", "/error", "/register", "/login", "/newaccount", "/resources/**").permitAll()
                .anyRequest().authenticated();
    }
}