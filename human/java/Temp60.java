import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class Temp60 {
    public static void main(String[] args) {
        // Create an instance of UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken authToken = 
            new UsernamePasswordAuthenticationToken("user", "password");

        // Example usage
        System.out.println("Principal: " + authToken.getPrincipal());
        System.out.println("Credentials: " + authToken.getCredentials());
    }
}