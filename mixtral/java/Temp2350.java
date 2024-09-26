import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class Temp2350 {

    public static void main(String[] args) {
        SpringApplication.run(Temp2350.class, args);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // Restrict Endpoints
                .antMatchers("/login/**").hasAnyRole("admin", "member")

                // Allow Forms
                .antMatchers("/member/**").permitAll()

                // Allow Resources
                .antMatchers("/js/**").permitAll()
                .antMatchers("/css/**").permitAll()

                // Trick to allow Internationalization
                .regexMatchers("\\/?lang=[a-z]{2}").permitAll()

                // Deny All
                .anyRequest().authenticated();

        return http.build();
    }
}