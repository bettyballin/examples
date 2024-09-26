import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // AAA URLs
        http
            .antMatcher("/aaa/**")
                .authorizeRequests()
                    .anyRequest().hasRole("AAA")
                    .and()
                .exceptionHandling()
                    .accessDeniedHandler(new CustomAccessDeniedHandlerAAA());

        // BBB URLs
        http
            .antMatcher("/bbb/**")
                .authorizeRequests()
                    .anyRequest().hasRole("BBB")
                    .and()
                .exceptionHandling()
                    .accessDeniedHandler(new CustomAccessDeniedHandlerBBB());

        // Other URLs
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .and()
            .httpBasic();
    }
}

class CustomAccessDeniedHandlerAAA implements org.springframework.security.web.access.AccessDeniedHandler {
    @Override
    public void handle(javax.servlet.http.HttpServletRequest request,
                       javax.servlet.http.HttpServletResponse response,
                       org.springframework.security.access.AccessDeniedException accessDeniedException) throws java.io.IOException, javax.servlet.ServletException {
        response.sendError(javax.servlet.http.HttpServletResponse.SC_FORBIDDEN, "Access Denied for AAA");
    }
}

class CustomAccessDeniedHandlerBBB implements org.springframework.security.web.access.AccessDeniedHandler {
    @Override
    public void handle(javax.servlet.http.HttpServletRequest request,
                       javax.servlet.http.HttpServletResponse response,
                       org.springframework.security.access.AccessDeniedException accessDeniedException) throws java.io.IOException, javax.servlet.ServletException {
        response.sendError(javax.servlet.http.HttpServletResponse.SC_FORBIDDEN, "Access Denied for BBB");
    }
}