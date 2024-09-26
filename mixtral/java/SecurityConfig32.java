import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Create users and assign roles

        User.UserBuilder user = User.withDefaultPasswordEncoder();

        auth
            .inMemoryAuthentication()
                .withUser(user.username("user1").password("pass").roles("USER").authorities("READ", "WRITE"));

        auth
            .inMemoryAuthentication()
                .withUser(user.username("admin").password("pass").roles("ADMIN").authorities("READ", "WRITE"));

        auth
            .inMemoryAuthentication()
                .withUser(user.username("superadmin").password("pass").roles("SUPERADMIN").authorities("READ", "WRITE"));

        auth
            .inMemoryAuthentication()
                .withUser(user.username("user2").password("pass").roles("USER").authorities("READ", "WRITE"));

        auth
            .inMemoryAuthentication()
                .withUser(user.username("user3").password("pass").roles("USER").authorities("READ", "WRITE"));
    }
}