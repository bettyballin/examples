import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig205 {

    private final AuthenticationProvider tokenAuthProvider;
    private final UsernamePasswordAuthenticationFilter tokenAuthFilter;

    public SecurityConfig205(AuthenticationProvider tokenAuthProvider, UsernamePasswordAuthenticationFilter tokenAuthFilter) {
        this.tokenAuthProvider = tokenAuthProvider;
        this.tokenAuthFilter = tokenAuthFilter;
    }

    @Bean
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
            .antMatcher("/api/**")
            .authenticationProvider(tokenAuthProvider)
            .addFilterBefore(tokenAuthFilter, BasicAuthenticationFilter.class)
            .authorizeRequests(authorize -> authorize
                .anyRequest().authenticated())
            .csrf().disable();
        return http.build();
    }
}