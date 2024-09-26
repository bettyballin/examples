import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class Temp3121 {

    public static void main(String[] args) {
        SpringApplication.run(Temp3121.class, args);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/control").hasRole("ADMIN")
                .antMatchers("/register", "/login_auth", "/login").permitAll()
                .antMatchers("/img/*.jpg", "/*.js", "/*.css").permitAll()
                .anyRequest().authenticated();

        return http.build();
    }
}