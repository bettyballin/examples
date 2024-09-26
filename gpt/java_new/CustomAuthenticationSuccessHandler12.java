import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import java.io.IOException;
import javax.servlet.ServletException;

@Component
public class CustomAuthenticationSuccessHandler12 implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Your logic to set custom tokens as cookies
        // response.addCookie(customCookie);
        
        // Optionally, you can redirect the user after setting the cookie
        // response.sendRedirect(yourRedirectUrl);
    }
}

@Configuration
@EnableWebSecurity
public class SAMLConfiguration {

    @Autowired
    private CustomAuthenticationSuccessHandler12 customAuthenticationSuccessHandler;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        // ... existing configuration
        return http.build();
    }

    // ... other beans and configuration
}