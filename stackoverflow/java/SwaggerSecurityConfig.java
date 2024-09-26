import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SwaggerSecurityConfig {

    @Bean
    public SecurityFilterChain swaggerFilterChain(HttpSecurity http) throws Exception {
        http
                .requestMatchers().antMatchers("/swagger-ui/index.html","/v3/api-docs/","/v3/api-docs")
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
        return http.build();
    }
}