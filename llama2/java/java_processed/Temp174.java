import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp174 {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        // Simulating the encoded password from DB
        String encodedPasswordFromDB = encoder.encode("myPassword");
        
        // Check if the password matches
        boolean isPasswordMatch = encoder.matches("myPassword", encodedPasswordFromDB);
        
        // Print the result
        System.out.println("Password match: " + isPasswordMatch);
    }
}