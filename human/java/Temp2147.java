import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp2147 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Spring Boot application entry point
        System.out.println("Spring Security Configuration Loaded");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .logout()
                .logoutSuccessUrl("http://your-auth-server/exit");
    }
}