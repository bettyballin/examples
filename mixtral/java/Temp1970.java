import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Temp1970 {

    public static void main(String[] args) {
        Temp1970 temp = new Temp1970();
        temp.restrictedMethod();
        temp.methodAccessibleByEveryoneIncludingThirdParty();
    }

    @PreAuthorize("!hasAnyRole('THIRD_PARTY_ROLE')")
    public void restrictedMethod() {
        // Only accessible for roles other than THIRD_PARTY_ROLE
        System.out.println("Restricted Method Accessed");
    }

    @PreAuthorize("permitAll() || hasAnyRole('THIRD_PARTY_ROLE')")
    public void methodAccessibleByEveryoneIncludingThirdParty() {
        // Accessible for everyone
        System.out.println("Method Accessible By Everyone Including Third Party Accessed");
    }
}