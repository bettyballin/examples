import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Temp2865 {
    public static void main(String[] args) {
        Temp2865 temp = new Temp2865();
        PasswordEncoder encoder = temp.passwordEncoder();
        System.out.println(encoder.encode("password"));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}