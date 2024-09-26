import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1620 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // The main method is not needed to configure security settings.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/login", "/register").permitAll()  // Allow everyone on these pages.
                .anyRequest().authenticated();                   // Require authentication everywhere else.
    }
}