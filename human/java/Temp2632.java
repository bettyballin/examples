import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class Temp2632 {
    public static void main(String[] args) {
        // Example usage of UsernamePasswordAuthenticationToken
        String username = "user";
        String password = "password";
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        
        System.out.println("Username: " + token.getPrincipal());
        System.out.println("Password: " + token.getCredentials());
    }
}