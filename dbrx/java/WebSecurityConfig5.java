import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ...

        http.exceptionHandling()
                .authenticationEntryPoint(new CustomOAuth2AuthenticationEntryPoint("Custom error message"));

        // ...
    }

    public static class CustomOAuth2AuthenticationEntryPoint implements AuthenticationEntryPoint {

        private final String customErrorMessage;

        public CustomOAuth2AuthenticationEntryPoint(String customErrorMessage) {
            this.customErrorMessage = customErrorMessage;
        }

        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, 
                             AuthenticationException authException) 
                             throws IOException, ServletException {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, customErrorMessage);
        }
    }
}