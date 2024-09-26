import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2046 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Normally Spring Boot application would be started here
        System.out.println("Spring Security Configuration");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/css/**", "/login*").permitAll() // Permit public resources
                .anyRequest().authenticated() // Require authentication for all other requests
            .and()
            .formLogin()
                .loginPage("/login") // Set the custom login page
            .and()
            .logout()
                .logoutUrl("/perform_logout"); // Define logout URL
    }
}