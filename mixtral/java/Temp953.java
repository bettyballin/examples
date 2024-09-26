import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp953 {
    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String userEnteredPlainTextPassword = "userPassword";
        String existingHashedAndSaltedStoredPassword = "$2a$10$DowJonesIndex1234567890abcdef"; // Example hashed password

        boolean isMatching = encoder.matches(userEnteredPlainTextPassword, existingHashedAndSaltedStoredPassword);

        if (isMatching) {
            // Passwords match
            System.out.println("Passwords match");
        } else {
            // Password mismatch
            System.out.println("Password mismatch");
        }
    }
}