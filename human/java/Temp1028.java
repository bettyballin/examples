import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.stereotype.Component;

@Component
public class Temp1028 {

    private final AuthenticationManager authenticationManager;

    public Temp1028(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        this.authenticationManager = authenticationConfiguration.getAuthenticationManager();
    }

    public static void main(String[] args) {
        // Spring Boot Application would be required to run this properly
        // SpringApplication.run(Temp1028.class, args);
    }
}