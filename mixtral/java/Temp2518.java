import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class Temp2518 extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // Your existing configuration

        http.exceptionHandling()
            .accessDeniedHandler(this.accessDeniedHandler);

        super.configure(http);
    }

    public static void main(String[] args) {
        // Spring Boot application entry point
        org.springframework.boot.SpringApplication.run(Temp2518.class, args);
    }
}

@Component
class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(javax.servlet.http.HttpServletRequest request,
                       javax.servlet.http.HttpServletResponse response,
                       org.springframework.security.access.AccessDeniedException accessDeniedException)
            throws java.io.IOException, javax.servlet.ServletException {
        response.sendRedirect("/access-denied");
    }
}