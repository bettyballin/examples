import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class Temp795 {
    public static void main(String[] args) throws Exception {
        AuthenticationManagerBuilder auth = new AuthenticationManagerBuilder(null);

        auth.inMemoryAuthentication()
            .withUser(User.withUsername("user").password("{noop}password").roles("USER"));

        // or

        auth.inMemoryAuthentication()
            .withUser(User.withUsername("user").password("{noop}password")
            .authorities(new SimpleGrantedAuthority("ROLE_USER")));
    }
}