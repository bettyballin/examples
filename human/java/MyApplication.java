import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class MyApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyApplication.class);

    public static void main(String[] args) {

        MyAuthenticationProvider authProvider;

        try (ConfigurableApplicationContext springApplicationContext = new AnnotationConfigApplicationContext(
                MySpringConfiguration.class)) {
            springApplicationContext.registerShutdownHook();
            authProvider = springApplicationContext.getBean(MyAuthenticationProvider.class);
        }

        Authentication request = new UsernamePasswordAuthenticationToken("foo", "foo");
        Authentication result = authProvider.authenticate(request);

        if (result.isAuthenticated()) {
            LOGGER.debug("User is authenticated");
        } else {
            LOGGER.debug("Cannot authenticate user.");
        }

    }

}

@Configuration
class MySpringConfiguration {

    @Bean
    public MyAuthenticationProvider myAuthenticationProvider() {
        return new MyAuthenticationProvider();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails user = User.withUsername("foo").password("{noop}foo").roles("USER").build();
        return new InMemoryUserDetailsManager(user);
    }
}

class MyAuthenticationProvider implements AuthenticationProvider {

    private final InMemoryUserDetailsManager userDetailsService;

    public MyAuthenticationProvider(InMemoryUserDetailsManager userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserDetails user = userDetailsService.loadUserByUsername(username);

        if (user != null && user.getPassword().equals("{noop}" + password)) {
            return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}