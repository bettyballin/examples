import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Bean;

public class Temp1236 {
    public static void main(String[] args) {
        Temp1236 temp = new Temp1236();
        PasswordEncoder encoder = temp.passwordEncoder();
        String encodedPassword = encoder.encode("password");
        System.out.println("Encoded Password: " + encodedPassword);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        String salt = "customSalt";

        return new MessageDigestPasswordEncoder("MD5", true, 1) {{
            setIterations(1);

            // Set the custom salt
            initSalt(salt);

            afterPropertiesSet();

            this.setEncodeHashAsBase64(false);
        }};
    }
}