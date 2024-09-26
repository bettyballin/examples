import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class Temp2250 {
    public static void main(String[] args) {
        Object principal = "user";
        Object credentials = "password";
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(principal, credentials);
        System.out.println("Authenticated: " + authToken.isAuthenticated());
    }
}