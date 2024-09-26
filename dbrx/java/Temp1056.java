import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class Temp1056 {
    public static void main(String[] args) {
        // Create a LogoutHandler
        LogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        
        // Create a LogoutFilter
        LogoutFilter logoutFilter = new LogoutFilter("/", logoutHandler);
        
        // Configure the LogoutFilter
        logoutFilter.setLogoutRequestMatcher(new AntPathRequestMatcher("/logout"));
        logoutFilter.setLogoutSuccessUrl("/");
        logoutFilter.setInvalidateHttpSession(true);
        
        // Adding the filter to the security context would typically be done in a Spring Security config
        // For this example, we're just printing out to show it's been set up
        System.out.println("LogoutFilter configured with URL: " + logoutFilter.getFilterProcessesUrl());
    }
}