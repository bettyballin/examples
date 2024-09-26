import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class Temp233 {

    public static void main(String[] args) {
        SpringApplication.run(Temp233.class, args);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(a -> a
                // Allow access for all users
                .antMatchers("/project/load*", "/project/details*").permitAll()
                // Require authentication
                .regexMatchers("\\A(/project/(e|c).*)").authenticated()
            );
        return http.build();
    }
}