import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@SpringBootApplication
public class Temp1465 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1465.class, args);
    }

    @Bean
    public AuthenticationEntryPoint customAuthEntry() {
        return new LoginUrlAuthenticationEntryPoint("/login");
    }
}