import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp1449 {
    public static void main(String[] args) {
        // Assuming you have an instance of Authentication
        Authentication auth = getAuthentication();

        // Create an empty SecurityContext
        SecurityContext emptyCtx = SecurityContextHolder.createEmptyContext();
        
        // Set the Authentication to the SecurityContext
        emptyCtx.setAuthentication(auth);
        
        // Set the SecurityContext to SecurityContextHolder
        SecurityContextHolder.setContext(emptyCtx);
    }
    
    private static Authentication getAuthentication() {
        // Implement this method to return an instance of Authentication
        // For example, you can use UsernamePasswordAuthenticationToken
        // return new UsernamePasswordAuthenticationToken("user", "password", new ArrayList<>());
        return null; // Replace this with actual implementation
    }
}