import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Temp1823 {
    public static void main(String[] args) {
        Temp1823 temp = new Temp1823();
        UserDetailsService userDetailsService = temp.userDetailsService();
        System.out.println("UserDetailsService initialized: " + userDetailsService);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        // Create the default "user" with password "password".
        String encodedPassword = passwordEncoder().encode("password");

        manager.createUser(
                User
                        .withUsername("user")
                        .password(encodedPassword)
                        .roles("USER")
                        .build());

        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}