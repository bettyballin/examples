import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;

@SpringBootApplication
public class Temp966 {
    public static void main(String[] args) {
        SpringApplication.run(Temp966.class, args);
    }
    
    @EnableWebSecurity
    public static class SecurityConfig {
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                .antMatchers("/script/**", "/css/**").permitAll() 
                .mvcMatchers(HttpMethod.POST, "/user/signup").permitAll() 
                .anyRequest().authenticated(); 

            http.formLogin();
            return http.build();
        }
    }
}