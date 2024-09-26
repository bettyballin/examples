import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Temp2620 {
    public static void main(String[] args) {
        // This is just a placeholder main method,
        // as the actual Spring Security configuration would be run in a Spring context.
        System.out.println("This is a Spring Security configuration example.");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // First encrypt the password string
        String encodedPassword = passwordEncoder().encode("1");

        // Set the password
        UserDetails user = User.builder()
                               .username("1")
                               .password(encodedPassword)
                               .roles("USER")
                               .build();

        // Use in-memory authentication with BCryptEncoder
        auth.inMemoryAuthentication()
            .withUser(user)
            .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}