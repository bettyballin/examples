import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Temp987 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method, if needed for testing or other purposes.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .headers().frameOptions().disable()
            .and()
            .antMatcher("/**").authorizeRequests()
            // Add your specific authorization configurations here
            .anyRequest().authenticated()
            .and()
            .exceptionHandling()
            .accessDeniedHandler((request, response, accessDeniedException) -> {
                if (isAjaxRequest(request)) {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN);
                } else {
                    // You can redirect to a custom error page or do something different
                    request.getRequestDispatcher("/error/403").forward(request, response);
                }
            });
        // @formatter:on
    }

    // Helper method for checking if the incoming request is an AJAX call
    private boolean isAjaxRequest(HttpServletRequest httpServletRequest) {
        return "XMLHttpRequest".equalsIgnoreCase(httpServletRequest.getHeader("X-Requested-With"));
    }
}