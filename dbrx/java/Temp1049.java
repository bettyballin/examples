import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp1049 {
    public static void main(String[] args) {
        String rawPassword = "yourPassword";  
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode(rawPassword);
        System.out.println("Hashed Password: " + hashedPassword);  
    }
}