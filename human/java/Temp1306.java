import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@EnableGlobalMethodSecurity(securedEnabled = true)
public class Temp1306 extends GlobalMethodSecurityConfiguration {
    public static void main(String[] args) {
        System.out.println("Global Method Security Enabled with securedEnabled = true");
    }
}