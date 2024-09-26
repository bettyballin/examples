import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp711 {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        // Sample user password from DB
        String encodedPassword = "$2a$10$7qJtRIJECx1kYhD.y7W3BeGk7/1N4b5V0ZMfK4O7E7b2i3y8/0mH."; // Example hashed password
        
        // Sample user input password
        String userInputPassword = "myPassword123";
        
        if (encoder.matches(userInputPassword, encodedPassword)) {
            System.out.println("Passwords match");
        } else {
            System.out.println("Passwords do not match");
        }
    }
}