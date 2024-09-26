import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebSecurityConfig {

    @Value("${security.form.login-url}")
    private String loginUrl;

    @Value("${security.form.login-success-url}")
    private String loginSuccessUrl;

    // Additional configuration methods can be added here

}