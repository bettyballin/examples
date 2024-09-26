import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

public class SecurityContextKey {
    public static void main(String[] args) {
        System.out.println(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
    }
}