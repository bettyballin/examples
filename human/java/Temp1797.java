import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class Temp1797 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1797.class, args);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/uri/**").hasAuthority("SOME_ROLE")
            .anyRequest().authenticated()
            .and()
            .httpBasic();
        return http.build();
    }
}