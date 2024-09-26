import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.annotation.Secured;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig extends GlobalMethodSecurityConfiguration {
}

public class Temp244 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SecurityConfig.class);
        Temp244 temp = context.getBean(Temp244.class);
        temp.updateRoom(1);
    }

    @PreAuthorize("@roomSecurity.checkRoomPermission(#roomId, 'manage')")
    public void updateRoom(int roomId) {
        // ...
        System.out.println("Room " + roomId + " updated.");
    }
}