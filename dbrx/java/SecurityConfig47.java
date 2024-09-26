import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;
import org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;
import org.springframework.security.oauth2.server.resource.BearerTokenError;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.AccessDeniedException;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BearerTokenResolver bearerTokenResolver() {
        return new DefaultBearerTokenResolver();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/configuration/**")
                .permitAll()
                .anyRequest()
                .authenticated();

        BearerTokenError error = new BearerTokenError("invalid_token", HttpStatus.UNAUTHORIZED.value(), "Invalid access token", null);
        BearerTokenAccessDeniedHandler handler = new CustomBearerTokenAccessDeniedHandler(error);
        http.exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .accessDeniedHandler(handler);
    }

}

class CustomBearerTokenAccessDeniedHandler implements AccessDeniedHandler {

    private final BearerTokenError error;

    public CustomBearerTokenAccessDeniedHandler(BearerTokenError error) {
        this.error = error;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, error.getDescription());
    }
}

Note that the only change was in the line where `BearerTokenError` is instantiated, I changed `HttpStatus.UNAUTHORIZED` to `HttpStatus.UNAUTHORIZED.value()` because `BearerTokenError` constructor expects an integer as the second argument, not an enum.