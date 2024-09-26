import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2065 {
    public static void main(String[] args) {
        System.out.println("Temp2065 application started!");
    }
}

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .logout()
                .addLogoutHandler((request, response, authentication) -> {
                    // Replace with actual token revoke service call
                    System.out.println("Tokens revoked for user-id");
                })
                .deleteCookies("JSESSIONID");
    }
}