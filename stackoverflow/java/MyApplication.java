import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class MyApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyApplication.class);

    public static void main(String[] args) {

        AuthenticationProvider authProvider;

        try (ConfigurableApplicationContext springApplicationContext = new AnnotationConfigApplicationContext(
                MySpringConfiguration.class)) {
            authProvider = springApplicationContext.getBean(AuthenticationProvider.class);
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