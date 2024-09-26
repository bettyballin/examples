import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;

@Configuration
public class SecurityConfig {

    @Autowired
    private Environment env;

    // Enable Basic Authentication if "production" or any other specific profiles are active
    @Profile("prod")
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        String username = env.getProperty("security.user.name");
        String password = env.getProperty("security.user.password");

        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> config
            = auth.inMemoryAuthentication();

        if (username != null && !"".equals(username)
                && password != null && !"".equals(password)) {

          // Add the user to in-memory authentication
          config
              .withUser(username).password("{noop}" + password).roles("");
        }
    }
}