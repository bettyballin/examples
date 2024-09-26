import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@SpringBootApplication
public class Temp1735 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1735.class, args);
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        RequestMatcher apiRequestMatcher = new AntPathRequestMatcher("/api/**");

        return http.authorizeHttpRequests((requests) ->
                requests.requestMatchers(apiRequestMatcher).authenticated()
                        .anyRequest().permitAll())
                .build();
    }
}