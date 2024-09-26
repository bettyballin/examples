import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class Temp1388 {
    public static void main(String[] args) {
        Object principal = "user";
        Object credentials = "password";
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(principal, credentials);
        System.out.println("Principal: " + token.getPrincipal());
        System.out.println("Credentials: " + token.getCredentials());
    }
}