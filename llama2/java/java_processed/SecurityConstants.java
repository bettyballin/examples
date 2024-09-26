import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public final class SecurityConstants {

    private static List<String> roles;

    @Value("${roles}")
    public void setRoles(List<String> roles) {
        SecurityConstants.roles = roles;
    }

    public static List<String> getRoles() {
        return roles;
    }
}