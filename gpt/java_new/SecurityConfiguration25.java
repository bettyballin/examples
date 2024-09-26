import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

public class SecurityConfiguration25 {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManagerBuilder authenticationManagerBuilder(PasswordEncoder passwordEncoder) {
        AuthenticationManagerBuilder authenticationManagerBuilder = new AuthenticationManagerBuilder(null);
        try {
            authenticationManagerBuilder
                .inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("deniss").password(passwordEncoder.encode("deniss1")).roles("USER")
                .and()
                .withUser("oksana").password(passwordEncoder.encode("oksana")).roles("USER", "ADMIN");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authenticationManagerBuilder;
    }
}