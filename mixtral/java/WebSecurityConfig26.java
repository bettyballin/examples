import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Other configurations...
        
        http.exceptionHandling()
            .accessDeniedHandler(customAccessDeniedHandler);

        // More configuration if needed
    }
}

class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(
        javax.servlet.http.HttpServletRequest request,
        javax.servlet.http.HttpServletResponse response,
        org.springframework.security.access.AccessDeniedException accessDeniedException
    ) throws java.io.IOException, javax.servlet.ServletException {
        response.sendError(javax.servlet.http.HttpServletResponse.SC_FORBIDDEN, "Access Denied!");
    }
}