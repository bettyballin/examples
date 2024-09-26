import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class Temp355 {
    public static void main(String[] args) {
        String username = "yourUsername";
        String password = "yourPassword";
        
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        
        // For demonstration purposes, let's print the token's details
        System.out.println("Username: " + authRequest.getPrincipal());
        System.out.println("Password: " + authRequest.getCredentials());
    }
}