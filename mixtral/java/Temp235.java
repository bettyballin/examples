import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp235 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // Spring Boot applications typically launch with SpringApplication.run
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .defaultSuccessUrl("/your-target-url")
                .loginPage("/login")
                .failureUrl("/login?error=true");
    }
}