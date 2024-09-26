package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class SecurityConfig {

    @Bean
    public SimpleUrlAuthenticationSuccessHandler authenticationSuccessHandler() {
        CustomSimpleURLAuthenticationSuccessHandler handler = new CustomSimpleURLAuthenticationSuccessHandler();
        handler.setDefaultTargetUrl("/dashboard.htm");
        return handler;
    }
}

class CustomSimpleURLAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    // Custom implementation here
}