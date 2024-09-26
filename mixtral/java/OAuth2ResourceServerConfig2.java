import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
@Order(2)
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    // ... other configurations

}

@Configuration
@Order(3)
protected class CustomAuthenticationManagerForResourcesConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configure your custom AuthenticationManager for resources here
    }

}