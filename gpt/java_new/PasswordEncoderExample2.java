import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderExample2 {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Storing the password in the database
        String rawPassword = "userEnteredPassword";
        String encodedPassword = encoder.encode(rawPassword);
        // Store encodedPassword in the database

        // Validating the input password with the stored password
        String inputPassword = "inputFromUserForChangePassword";
        boolean isPasswordMatch = encoder.matches(inputPassword, encodedPassword);

        if (isPasswordMatch) {
            // Passwords match
        } else {
            // Passwords do not match
        }
    }
}