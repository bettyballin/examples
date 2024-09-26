import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp2038 {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("myPassword");

        if (passwordEncoder.matches("myPassword", hashedPassword)) {
            System.out.println("Password matches!");
        } else {
            System.out.println("Password does not match!");
        }
    }
}