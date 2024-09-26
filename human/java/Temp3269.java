import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp3269 {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("myPassword");
        System.out.println("Encoded Password: " + encodedPassword);
    }
}


Make sure to add the necessary Spring Security dependencies to your project for this code to compile and run successfully.