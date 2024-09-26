import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class Temp1303 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // This main method is not typically used for Spring Boot applications.
        // Spring Boot applications are usually started with a Spring Boot Application class.
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser("admin").password("{noop}password").roles("ADMIN"); // admin in your case
    }

}