import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthSupportChecker {

    public boolean supports(Class<?> auth) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(auth));
    }

    public static void main(String[] args) {
        AuthSupportChecker checker = new AuthSupportChecker();
        
        // Test with UsernamePasswordAuthenticationToken class
        boolean result1 = checker.supports(UsernamePasswordAuthenticationToken.class);
        System.out.println("Supports UsernamePasswordAuthenticationToken: " + result1);
        
        // Test with another class (e.g., String class)
        boolean result2 = checker.supports(String.class);
        System.out.println("Supports String: " + result2);
    }
}