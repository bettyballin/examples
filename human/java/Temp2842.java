import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

public class Temp2842 {
    public static void main(String[] args) {
        // For demonstration purposes, we're creating an HttpSecurity instance to configure session management.
        HttpSecurity httpSecurity = new HttpSecurity(null, null, null, null, null, null);
        try {
            httpSecurity.sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            System.out.println("Session creation policy set to STATELESS.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}