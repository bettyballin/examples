import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;

@Component
public class SomeClass4 {

    @Value("#{authenticationConfiguration.authenticationManager}")
    private AuthenticationManager authenticationManager;
    
    // Other fields and methods
}