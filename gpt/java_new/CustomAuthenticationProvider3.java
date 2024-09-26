import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider3 {

    private final SimpleService simpleService;

    @Autowired
    public CustomAuthenticationProvider3(SimpleService simpleService) {
        this.simpleService = simpleService;
    }

    // Assuming you have other methods that use simpleService
}