import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.io.Serializable;

public interface CustomMethodSecurityExpressionHandler {
    boolean hasPermission(Authentication authentication, Serializable targetId);
}

@Service
public class MyCustomMethodSecurityExpressionHandler implements CustomMethodSecurityExpressionHandler {

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId) {
        // Your custom authorization logic here
        return true;
    }
}