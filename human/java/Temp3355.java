import org.springframework.http.HttpStatus;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class Temp3355 {
    public static void main(String[] args) {
        // Assuming 'http' is an instance of HttpSecurity which is typically configured in a Spring Security configuration class
        // Here we will create a mock configuration to make this code executable

        // Creating a mock HttpSecurity object
        HttpSecurity http = new HttpSecurity();

        // Configuring the logout settings
        http
            .logout()
            .invalidateHttpSession(true)
            .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK));
    }
}

// Mocking necessary Spring Security classes for demonstration purposes
class HttpSecurity {
    public LogoutConfigurer logout() {
        return new LogoutConfigurer();
    }
}

class LogoutConfigurer {
    public LogoutConfigurer invalidateHttpSession(boolean invalidate) {
        System.out.println("Invalidating HTTP session: " + invalidate);
        return this;
    }

    public LogoutConfigurer logoutSuccessHandler(LogoutSuccessHandler logoutSuccessHandler) {
        System.out.println("Setting logout success handler: " + logoutSuccessHandler);
        return this;
    }
}