import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

public class Temp2556 {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = delegatingPasswordEncoder();
        System.out.println(passwordEncoder.encode("password"));
    }

    @Bean
    public static PasswordEncoder delegatingPasswordEncoder() {
        Map<String, PasswordEncoder> encoders = new HashMap<>();

        encoders.put("bcrypt", new BCryptPasswordEncoder());
        // Add other password encoder implementations here if needed

        return new DelegatingPasswordEncoder("bcrypt", encoders);
    }
}