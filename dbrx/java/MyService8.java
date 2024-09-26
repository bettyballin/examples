import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class MyService {

    @PreAuthorize("hasRole('ROLE_USER')")
    public void someMethod() {
        // ...
        System.out.println("someMethod executed");
    }
}

@Configuration
@ComponentScan(basePackages = "com.example")
@EnableGlobalMethodSecurity(prePostEnabled = true)
class AppConfig {
}

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}

@Configuration
class UserDetailsServiceConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        User user = new User("user", "password", Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
        return new InMemoryUserDetailsManager(Collections.singletonList(user));
    }
}

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, SecurityConfig.class, UserDetailsServiceConfig.class);

        MyService myService = context.getBean(MyService.class);
        try {
            org.springframework.security.authentication.UsernamePasswordAuthenticationToken authentication = new org.springframework.security.authentication.UsernamePasswordAuthenticationToken("user", "password");
            org.springframework.security.core.context.SecurityContextHolder.getContext().setAuthentication(authentication);
            myService.someMethod();
        } catch (Exception e) {
            System.out.println("Authorization failed: " + e.getMessage());
        }

        context.close();
    }
}