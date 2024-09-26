import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.RequestHeaderRequestMatcher;

@EnableWebSecurity
public class SecurityConfig212 {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .oauth2Login()
                .redirectionEndpoint()
                    .baseUri("/login/oauth2/code/cognito")
                    .and()
            .logout()
                .and()
            .oauth2Client()
                .and()
            .requestMatcher(new RequestHeaderRequestMatcher("Authorization"))
            .authorizeRequests()
                .requestMatchers(new RequestHeaderRequestMatcher("Authorization"))
                .authenticated();
        
        return http.build();
    }
    
    // Dummy logoutSuccessHandler for demonstration purposes.
    private LogoutSuccessHandler logoutSuccessHandler() {
        return (request, response, authentication) -> {
            // Custom logout handling code
        };
    }
}