import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

public class Temp94 {
    public static void main(String[] args) throws Exception {
        HttpSecurity http = new HttpSecurity(null, null, null);

        // Example custom session authentication strategy
        SessionAuthenticationStrategy yourCustomSessionAuthStrat = (authentication, request, response) -> {
            // Custom logic here
        };

        http
            .sessionManagement()
                .sessionAuthenticationStrategy(yourCustomSessionAuthStrat);
    }
}