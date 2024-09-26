import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;

public class Temp2915 {
    @Bean(name = "passwordEncoder")
    public BCryptPasswordEncoder getPasswordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(BCryptVersion.$2B);
        return bCryptPasswordEncoder;
    }

    public static void main(String[] args) {
        Temp2915 temp = new Temp2915();
        BCryptPasswordEncoder encoder = temp.getPasswordEncoder();
        System.out.println(encoder.encode("myPassword"));
    }
}