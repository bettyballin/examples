import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1827 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // Main method can be used to start a Spring Boot application
        // SpringApplication.run(Temp1827.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configure /api/** with stateless security
        http
            .antMatcher("/api/**")
                .authorizeRequests()
                    .anyRequest().authenticated()
                        .and()
                .httpBasic();

        // Other requests (non-API)
        http
            .authorizeRequests()
                    .anyRequest().authenticated()
                        .and()
            .formLogin();
    }
}