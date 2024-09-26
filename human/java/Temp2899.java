import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp2899 {
    public static void main(String[] args) {
        Temp2899 temp = new Temp2899();
        BCryptPasswordEncoder encoder = temp.passwordEncoder();
        System.out.println(encoder.encode("password"));
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}