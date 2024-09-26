import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class Temp2554 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Temp2554.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests((requests) -> requests
                .antMatchers("/login/**", "/css/**", "/js/**", "/registration/**").permitAll()
                // ...
            )
            .authenticationProvider(authProvider());
            // ...
    }

    @Bean
    public AuthenticationProvider authProvider() {
        // Define and return your AuthenticationProvider implementation here
        return null;
    }
}