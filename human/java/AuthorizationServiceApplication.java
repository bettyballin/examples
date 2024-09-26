import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;

@SpringBootApplication
@RestController
public class AuthorizationServiceApplication {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/user")
    public Principal user(Principal user) {
        log.info("User information display for User: " + user.getName());
        return user;
    }

    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("deniss").password("{noop}deniss").roles("USER").build());
        return manager;
    }

    public static void main (String[] args) {
        SpringApplication.run(AuthorizationServiceApplication.class, args);
    }
}