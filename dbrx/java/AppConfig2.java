import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "com.example")
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return new SecurityConfig().configure(http);
    }

    @Configuration
    static class SecurityConfig {
        @Bean
        public SecurityFilterChain configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().authenticated();
            return http.build();
        }
    }
}