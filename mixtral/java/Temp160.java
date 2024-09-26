import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp160 {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        String enteredPassword = "entered_password";
        String retrievedHashedAndSaltedPw = "$2a$10$Dow1D2.QE0hW6xQ0E0s9aeKpCw5Y5K6RZ0yQe8zkOj6qB8zZ29VbO"; // Example hash
        
        boolean isValidLoginAttempt = passwordEncoder.matches(enteredPassword, retrievedHashedAndSaltedPw);
        if (isValidLoginAttempt) {
            System.out.println("Allow user to log in");
        } else {
            System.out.println("Inform the user that their login attempt was invalid");
        }
    }
}