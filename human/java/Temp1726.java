import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {

    @Bean
    public AuthenticationSuccessHandler successLoginHandler() {
        return new RedirectLoginSuccessHandler();
    }
}

// Assuming RedirectLoginSuccessHandler is a class in the package com.myapp.security
package com.myapp.security;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class RedirectLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    public RedirectLoginSuccessHandler() {
        super();
        // Custom configuration for the success handler can be added here
    }
}