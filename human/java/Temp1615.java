import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

public class Temp1615 {
    public static void main(String[] args) {
        String securityContextKey = HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;
        System.out.println(securityContextKey);
    }
}