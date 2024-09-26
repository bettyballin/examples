import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp2089 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method is typically not needed for Spring Security configuration
        // Spring Boot will auto-configure and run the application if you have the right setup
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/**").hasRole("USER")
            .and()
            .formLogin().loginPage("/login").permitAll();
    }
}