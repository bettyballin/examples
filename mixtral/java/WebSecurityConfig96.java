import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AttemptService attemptService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthFailureHandler customAuthenticationFailureHandler = new CustomAuthFailureHandler(attemptService);

        http.formLogin()
            .failureHandler(customAuthenticationFailureHandler);

        // Other configurations
    }
}

// Assuming that CustomAuthFailureHandler is defined as follows:
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final AttemptService attemptService;

    public CustomAuthFailureHandler(AttemptService attemptService) {
        this.attemptService = attemptService;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        attemptService.recordFailedAttempt(request.getParameter("username"));
        super.onAuthenticationFailure(request, response, exception);
    }
}

// Example AttemptService class:
public class AttemptService {
    public void recordFailedAttempt(String username) {
        // Implementation of recording a failed attempt
    }
}