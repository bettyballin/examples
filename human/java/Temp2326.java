import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2326 extends WebSecurityConfigurerAdapter {
    private final ThirdPartyAuthenticationProvider authProvider;

    public Temp2326(ThirdPartyAuthenticationProvider authProvider) {
        this.authProvider = authProvider;
    }

    public static void main(String[] args) {
        // Spring Boot would typically run this application
        // SpringApplication.run(Temp2326.class, args);
        System.out.println("This is a Spring Security configuration class.");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
}

// Assuming the ThirdPartyAuthenticationProvider class exists somewhere in your codebase.
class ThirdPartyAuthenticationProvider {
    // Implementation details for the provider
}