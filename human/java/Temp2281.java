import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.configuration.SecurityProperties;

public class Temp2281 {
    public static void main(String[] args) {
        int ACCESS_OVERRIDE_ORDER = SecurityProperties.BASIC_AUTH_ORDER - 2; // 39
        int BASIC_AUTH_ORDER = Ordered.LOWEST_PRECEDENCE - 5; // 41

        System.out.println("ACCESS_OVERRIDE_ORDER: " + ACCESS_OVERRIDE_ORDER);
        System.out.println("BASIC_AUTH_ORDER: " + BASIC_AUTH_ORDER);
    }
}