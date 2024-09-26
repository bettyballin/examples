import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

public class Temp2835 {
    public static void main(String[] args) {
        String securityContextKey = HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;
        System.out.println("Security Context Key: " + securityContextKey);
    }
}