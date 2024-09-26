import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp664 {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "myPassword";
        String encodedPassword = passwordEncoder.encode(password);
        
        System.out.println("Password: " + password);
        System.out.println("Encoded Password: " + encodedPassword);
    }
}