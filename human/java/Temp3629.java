import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Temp3629 {

    public static void main(String[] args) {
        SpringApplication.run(Temp3629.class, args);
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        List<String> publicApis = Arrays.asList("/api/public/**");
        return (web) -> web.ignoring().requestMatchers(publicApis.toArray(String[]::new));
    }
}