import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

@Configuration
public class ExceptionHandlingConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ... your existing configuration

        http.exceptionHandling()
            .accessDeniedHandler((request, response, accessDeniedException) ->
                ((HttpServletResponse)response).sendError(403));

        super.configure(http);
    }
}