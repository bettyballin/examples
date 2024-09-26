import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Import(AuthenticationConfiguration.class)
public @interface EnableGlobalAuthentication {}

public class Main {
    public static void main(String[] args) {
        System.out.println("EnableGlobalAuthentication annotation is defined.");
    }
}