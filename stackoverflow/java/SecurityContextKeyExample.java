import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

public class SecurityContextKeyExample {
    public static void main(String[] args) {
        String key = HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;
        System.out.println("Security context key: " + key);
    }
}