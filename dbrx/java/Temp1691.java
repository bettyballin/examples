import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableWebSecurity
public class Temp1691 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1691.class, args);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authz -> authz.antMatchers("/h2-console/**").authenticated())
            .formLogin().and()
            .csrf(csf -> csf.ignoringAntMatchers("/h2-console/**"))
            .headers(headers -> headers.frameOptions().sameOrigin());
        return http.build();
    }
}