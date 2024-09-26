import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

public class CustomSecurityConfigurer1 extends AbstractHttpConfigurer<CustomSecurityConfigurer1, HttpSecurity> {

    @Override
    public void init(HttpSecurity http) throws Exception {
        // Initialization code here
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // Configuration code here
    }

    // Method to add this custom configurer to the HttpSecurity
    public static CustomSecurityConfigurer1 customSecurityConfigurer() {
        return new CustomSecurityConfigurer1();
    }
}