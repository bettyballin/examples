import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Temp2453 {
    public static void main(String[] args) {
        Temp2453 temp = new Temp2453();
        BCryptPasswordEncoder encoder = temp.bCryptPasswordEncoder();
        System.out.println(encoder.encode("password"));
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}