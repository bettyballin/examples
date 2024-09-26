import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Bean;

public class Temp2450 {
    public static void main(String[] args) {
        Temp2450 temp = new Temp2450();
        temp.delegatingPasswordEncoder();
    }

    @Bean
    public PasswordEncoder delegatingPasswordEncoder() {
        Map<String, PasswordEncoder> encoders = new HashMap<>();

        // Add BCrypt as default
        encoders.put("bcrypt", new BCryptPasswordEncoder());

        return new DelegatingPasswordEncoder("bcrypt", encoders) {
            @Override
            public PasswordEncoder getDefault() {
                return this.getOrDefault("bcrypt");
            }

            // Upgrade the encoding scheme when users log in with older password formats
            @PostConstruct
            private void setupMessageSourceAccessException() throws Exception {
                MessageSourceAccessor messageSource = new MessageSourceAccessor(this.messageSource);
                Map<String, PasswordEncoder> encodersCopy = Collections.unmodifiableMap(this.encoders);

                for (PasswordEncoder passwordEncoder : encodersCopy.values()) {
                    if (!passwordEncoder.getClass().getSimpleName().equals("BCryptPasswordEncoder")) {
                        this.upgradeEncoding(messageSource, "bcrypt", passwordEncoder);
                    }
                }
            }
        };
    }
}