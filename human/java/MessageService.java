import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

@Service
public class MessageService {
    @Autowired
    private Authz authz;

    // we pass in the name argument into our custom expression Authz.isComprador
    @PreAuthorize("@authz.isComprador()")
    String greetForName(String name) {
        return "Hello " + name;
    }
}

@Component
class Authz {
    public boolean isComprador() {
        // Custom logic to check if the user is a "comprador"
        return true; // Simplified for demonstration
    }
}