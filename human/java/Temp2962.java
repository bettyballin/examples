import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2962 {
    public static void main(String[] args) {
        System.out.println("Spring Security Custom Configurer Example");
    }
}

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.apply(new CustomSecurityConfigurer());
    }
}

class CustomSecurityConfigurer extends org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer<CustomSecurityConfigurer, HttpSecurity> {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        // Custom security configuration logic
    }
}