import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.access.AccessDeniedHandler;

public class Temp749 {
    public static void main(String[] args) {
        HttpSecurity http = new HttpSecurity(null, null, null); // This would normally be configured in a Spring Security configuration class
        AccessDeniedHandler accessDeniedHandler = (request, response, accessDeniedException) -> {}; // This would normally be implemented or configured elsewhere

        try {
            http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}