import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class PasswordEncoderExample1 {
    public static void main(String[] args) {
        StandardPasswordEncoder encoder = new StandardPasswordEncoder("secret");
        String encodedPassword = encoder.encode("myPassword");
        
        // Simulating database retrieval with the same encoded password
        String encodedPasswordFromDb = encodedPassword;
        
        // Use the matches method to compare the raw password with the encoded password
        boolean isPasswordMatch = encoder.matches("myPassword", encodedPasswordFromDb);
        
        if (isPasswordMatch) {
            // Authentication successful
            System.out.println("Authentication successful");
        } else {
            // Authentication failed
            System.out.println("Authentication failed");
        }
    }
}