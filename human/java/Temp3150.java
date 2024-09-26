import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class Temp3150Application {

    public static void main(String[] args) {
        SpringApplication.run(Temp3150Application.class, args);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
            .authorizeRequests()
                .antMatchers("/private").hasRole("ADMIN")
                .antMatchers("/private/**").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
            .httpBasic();

        return http.build();
    }
}