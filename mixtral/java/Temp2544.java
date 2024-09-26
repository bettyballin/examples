import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;

@SpringBootApplication
public class Temp2544 {

    public static void main(String[] args) {
        SpringApplication.run(Temp2544.class, args);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeRequests((authz) -> authz
                .antMatchers("/h2-console/**").authenticated()
                .anyRequest().permitAll())
             .formLogin()
             .csrf((c) -> c.ignoringAntMatchers("/h2-console/**"))
            .headers(header -> header
                    .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
        .build();
    }
}