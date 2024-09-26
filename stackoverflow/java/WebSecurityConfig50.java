import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig50 {

    @Bean
    public SecurityFilterChain coreFilterChain(HttpSecurity http) throws Exception {
        http
            .requestMatchers(matchers -> matchers.antMatchers("/api/core/**"))
            .authorizeRequests(auth -> auth
                .antMatchers("/api/core/**").permitAll()
                .anyRequest().authenticated()
            );
        
        return http.build();
    }

    @Bean
    public SecurityFilterChain module2FilterChain(HttpSecurity http) throws Exception {
        http
            .requestMatchers(matchers -> matchers.antMatchers("/api/module2/**"))
            .authorizeRequests(auth -> auth
                .antMatchers("/api/module2/**").permitAll()
                .anyRequest().authenticated()
            );

        return http.build();
    }
}