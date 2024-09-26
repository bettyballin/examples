import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.stereotype.Component;

@Component
public class Temp1938 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        System.out.println("Spring Security Configuration Loaded.");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Disable CSRF protection since it's not needed in your case
        http.csrf().disable();

        // Configure authorization rules
        http
            .authorizeRequests()
                .antMatchers("/rst/**").permitAll()
                .anyRequest().authenticated();

        // Disable session management since it's a stateless RESTful API
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}