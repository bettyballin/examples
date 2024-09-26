import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerBuilder;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;

    public AuthenticationController(final ProviderManager providerManager) throws Exception {
        this.authenticationManager = new AdapterAuthenticationManager(providerManager);
    }

    @GetMapping("/sign-in")
    public String signIn() {
         System.out.println(this.authenticationManager);
         return "Hello World";
     }
}

@Configuration
public class JwtConfiguraion {

    // ... other beans

    @Bean
    public ProviderManager providerManager(final HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        return (ProviderManager) authenticationManagerBuilder
                 .parentAuthenticationManager((AuthenticationManager) null).build();
    }

}

// Dummy class to make the code compile
class AdapterAuthenticationManager implements AuthenticationManager {
    private final ProviderManager providerManager;

    public AdapterAuthenticationManager(ProviderManager providerManager) {
        this.providerManager = providerManager;
    }

    @Override
    public org.springframework.security.core.Authentication authenticate(org.springframework.security.core.Authentication authentication) throws org.springframework.security.core.AuthenticationException {
        return providerManager.authenticate(authentication);
    }
}