import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserService userService;

    // Basic authentication for API
    @Configuration
    public static class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserService userService;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/api/**")
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .httpBasic();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userService);
        }
    }

    // Form-based login for web pages
    @Configuration
    public static class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserService userService;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/webapp/**")
                .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                .formLogin();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userService);
        }
    }
}


To make this code executable, you would also need to define the `UserService` class and ensure it implements the `UserDetailsService` interface from Spring Security. Here is a simple example:


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implement your user loading logic here
        return null;
    }
}


This code provides a minimal setup required to make the original configurations work. You would need to fill in the user loading logic in `UserService` according to your application's requirements.