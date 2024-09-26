import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp3006 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin().loginPage("/login.jsp")
            .defaultSuccessUrl("/homeLogged", true)
            .permitAll();
    }

    public static void main(String[] args) {
        // Spring Boot applications typically use an embedded web server, so main method is not used for HttpSecurity configuration.
        // This class would be picked up by Spring Security automatically if it's part of a Spring Boot application.
    }
}