import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.http.HttpMethod;

public class Temp1874 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic()
                .and().authorizeRequests()
                    // First define the most specific URL patterns
                    .antMatchers("/api/addItem").hasRole("ADMIN")
                    .antMatchers("/api/deleteItem/**").hasRole("ADMIN")

                    // Then less specific ones
                    .antMatchers(HttpMethod.GET, "/api/items", "/api/items/*").hasAnyRole("USER", "ADMIN")

                // Finally any other request should be authenticated
                 .anyRequest().authenticated()

            .and().csrf().disable();
    }

    public static void main(String[] args) {
        // This is a configuration class, typically you would run this in a Spring Boot application
    }
}