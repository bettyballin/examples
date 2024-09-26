import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig117urerAdapter;

@EnableWebSecurity
public class SecurityConfig117 extends WebSecurityConfig117urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .sessionManagement()
                .sessionFixation()
                    .migrateSession();
    }
}