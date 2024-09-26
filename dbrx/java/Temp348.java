import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp348 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/foo/**").permitAll() 
            .and().exceptionHandling().accessDeniedPage("/in_development_page.html");
    }

    public static void main(String[] args) {
        System.out.println("Spring Security configuration initialized.");
    }
}