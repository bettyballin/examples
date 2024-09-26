import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class Temp2585 {
    public static void main(String[] args) {
        SpringApplication.run(Temp2585.class, args);
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .formLogin()
                .and()
                .csrf().disable()
                .authorizeRequests((requests) -> requests
                        .mvcMatchers("/").permitAll()
                        .mvcMatchers("/home/**").authenticated())
                .build();
    }
}