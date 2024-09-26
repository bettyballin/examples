import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class YourClassName3 {

    @Value("${JWT_SECRET}")
    private String jwtSecret;

    // Rest of your class content
}