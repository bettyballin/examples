import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Temp754 {
    public static void main(String[] args) {
        // Assuming http is an instance of HttpSecurity
        // This code will not run as-is because it requires a Spring Security context
        // and proper configuration of the HttpSecurity object.
        // Below is a placeholder to represent the intended configuration.

        // Example usage, this should be configured inside a Spring Security configuration class
        // HttpSecurity http = ...;

        // http.logout()
        //    .logoutSuccessHandler(logoutSuccessHandler())
        //    .deleteCookies("JSESSIONID")
        //    .clearAuthentication(true)
        //    .invalidateHttpSession(false);
    }

    // Placeholder method for logoutSuccessHandler
    private static LogoutSuccessHandler logoutSuccessHandler() {
        return new LogoutSuccessHandler() {
            @Override
            public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                // Implement your logout success handling logic here
            }
        };
    }
}