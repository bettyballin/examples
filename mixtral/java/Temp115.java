import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.context.annotation.Configuration;

// Assuming roleConstants is defined somewhere in your application
class RoleConstants {
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
}

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Temp115 {

    public static void main(String[] args) {
        Temp115 obj = new Temp115();
        obj.method();
    }

    @PreAuthorize("hasRole('" + RoleConstants.ROLE_ADMIN + "')")
    public void method() {
        System.out.println("Method executed!");
    }
}