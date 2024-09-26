import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig157urerAdapter;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:users.properties")
public class SecurityConfig157 extends WebSecurityConfig157urerAdapter {

    @Value("${user1.username}")
    private String user1Username;

    @Value("${user1.password}")
    private String user1Password;

    @Value("${user2.username}")
    private String user2Username;

    @Value("${user2.password}")
    private String user2Password;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .and()
            .httpBasic();
    }
}