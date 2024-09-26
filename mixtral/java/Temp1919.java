import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
public class Temp1919 extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProvider authProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .requestMatcher(request -> true) // Replace with a real request matcher
            // other configurations
            .and()
            .authenticationProvider(authProvider);
    }

    public static void main(String[] args) {
        // Spring Boot applications typically run with SpringApplication.run()
        // SpringApplication.run(Temp1919.class, args);
    }
}