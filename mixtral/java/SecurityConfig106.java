import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.InMemoryUserDetailsManagerConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${security.user.password}")
    private String password;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        UserDetails user = User
            .withUsername("test")
            .password(encoder.encode(password))
            .roles()
            .build();

        InMemoryUserDetailsManagerConfigurer<HttpSecurity> inMemoryAuthentication = http
                .authorizeRequests().anyRequest().authenticated()
                    .and()
                .httpBasic()
                    .realmName("My App")
                    .and()
                .sessionManagement();

        if (user != null) {
            inMemoryAuthentication.withUser(user);
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}