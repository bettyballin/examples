import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2120 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Entry point for the application
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // permit all requests to static resources
                .antMatchers("/static/**").permitAll()
                // allow access to login and registration pages
                .antMatchers("/", "/registration").anonymous()
                // any other request requires authentication
                .anyRequest().authenticated();
    }
}