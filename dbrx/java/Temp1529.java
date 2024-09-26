import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp1529 {
    public static void main(String[] args) {
        // Placeholder for userDetailsService
        Object userDetailsService = new Object(); 
        
        authUserDetailsService(userDetailsService).passwordEncoder(encodePasswd());
    }

    private static AuthConfigurer authUserDetailsService(Object userDetailsService) {
        return new AuthConfigurer(userDetailsService);
    }

    private static PasswordEncoder encodePasswd() {
        return new BCryptPasswordEncoder();
    }
}

class AuthConfigurer {
    private Object userDetailsService;

    public AuthConfigurer(Object userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public AuthConfigurer passwordEncoder(PasswordEncoder passwordEncoder) {
        // Mock implementation for passwordEncoder
        System.out.println("Password encoder set: " + passwordEncoder);
        return this;
    }
}