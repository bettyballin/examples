import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;

public class Temp78 {
    public static void main(String[] args) {
        // Your main application logic here
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth, HttpSecurity http) throws Exception {
        // Configure your custom authentication provider here

        BasicAuthenticationFilter securityAnonymousAuthFilter = new BasicAuthenticationFilter(auth.getOrBuild());

        securityAnonymousAuthFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/your_path"));

        AuthenticationEntryPoint entryPoint = new LoginUrlAuthenticationEntryPoint("/login");

        AuthenticationFailureHandler failureHandler = (request, response, exception) -> {
            request.getSession().setAttribute("SPRING_SECURITY_LAST_EXCEPTION", exception);

            // Redirect to login page
            String redirectUrl = "/login?error";

            if (exception instanceof AccountExpiredException ||
                    exception instanceof CredentialsExpiredException ||
                    exception instanceof DisabledException) {
                // Redirect to account locked page
                redirectUrl += "&expired";
            } else {
                HttpServletRequest httpRequest = ((HttpServletRequest) request);

                if (httpRequest.getHeader("X-Requested-With") != null &&
                        httpRequest.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
                    // This is an AJAX request
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                } else {
                    HttpServletResponse httpResponse = ((HttpServletResponse) response);
                    httpResponse.sendRedirect(redirectUrl);
                }
            }
        };

        // You should add security configurations here, e.g.:
        // http.exceptionHandling().authenticationEntryPoint(entryPoint).and().formLogin().failureHandler(failureHandler);
    }
}