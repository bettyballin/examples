import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManagerConfigurer;

@EnableWebSecurity
public class Temp2456 {
    public static void main(String[] args) {
        // This main method is just a placeholder
        // Spring Boot applications typically use SpringApplication.run to start the app
    }

    @Autowired
    public void configureGlobalSecurity(final AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        UserDetails user1 = User.withUsername("user").password(encoder.encode("pwdd")).roles("USER").build();

        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> mngConfig = auth.inMemoryAuthentication()
                .withUser(user1);
    }
}