import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Temp1216 extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder pe = new BCryptPasswordEncoder();

        // Set up in-memory authentication
        User.UserBuilder users = User.withDefaultPasswordEncoder();

        auth
            .inMemoryAuthentication()
            .withUser(users.username("user").password("password").roles("USER"));
    }

    public static void main(String[] args) {
        // Spring Boot application would normally start here
        System.out.println("Spring Security Configuration Loaded");
    }
}