import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public static class ApplicationSecurity extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Add custom configuration
        CustomSecurityConfiguration
            .init()
            .configure(http);
    }
}

// Dummy CustomSecurityConfiguration class to make the code executable
class CustomSecurityConfiguration {
    public static CustomSecurityConfiguration init() {
        return new CustomSecurityConfiguration();
    }
    
    public void configure(HttpSecurity http) throws Exception {
        // Add your custom security configurations here
    }
}