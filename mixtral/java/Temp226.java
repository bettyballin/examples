import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class Temp226 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Spring Boot applications typically use SpringApplication.run to start the application
        // SpringApplication.run(Temp226.class, args);
        System.out.println("Configure method will be called by Spring Security during startup.");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated();
    }
}