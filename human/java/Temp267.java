import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class Temp267 {
    public static void main(String[] args) {
        Temp267 instance = new Temp267();
        instance.someMethod();
    }

    @Secured("ROLE_SPECIAL_USER")
    public void someMethod() {
        System.out.println("Executing some special code for ROLE_SPECIAL_USER");
    }
}