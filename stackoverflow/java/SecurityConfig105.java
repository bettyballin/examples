import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

public class SecurityConfig105 {
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("sahil")
            .password(NoOpPasswordEncoder.getInstance().encode("123"))
            .roles("ADMIN", "USER");
    }
}