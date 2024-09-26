import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class Temp920Application {

    public static void main(String[] args) {
        SpringApplication.run(Temp920Application.class, args);
    }

    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.csrf().disable()
                    .authorizeRequests()
                        .antMatchers("/rest/**").authenticated() // secure /rest/**
                        .anyRequest().permitAll() // allow other requests (e.g login)
                    .and()
                        .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                        .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            }
        };
    }
}

class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    // Implement the filter (not provided in the original code)
}

class JWTAuthorizationFilter extends UsernamePasswordAuthenticationFilter {
    public JWTAuthorizationFilter() {
        // Implement the filter (not provided in the original code)
    }

    public JWTAuthorizationFilter(org.springframework.security.authentication.AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }
}