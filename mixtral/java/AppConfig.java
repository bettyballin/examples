import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String role() {
        return OtherClass.ROLE;
    }
}

class OtherClass {
    public static final String ROLE = "USER_ROLE";
}