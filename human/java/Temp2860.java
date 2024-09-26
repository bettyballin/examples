import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class Temp2860 {
    public static void main(String[] args) {
        CustomAuthenticationToken token = new CustomAuthenticationToken("user", "password");
        System.out.println("Principal: " + token.getPrincipal());
        System.out.println("Credentials: " + token.getCredentials());
    }
    
    static class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {
        public CustomAuthenticationToken(Object principal, Object credentials) {
            super(principal, credentials);
        }
    }
}