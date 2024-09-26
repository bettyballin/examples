import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http, AuthenticationConfiguration authenticationConfiguration) throws Exception {
        AuthenticationManager authenticationManager = authenticationConfiguration.getAuthenticationManager();

        var jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager);

        var jwtAuthorisationFilter = new JwtAuthorisationFilter();

        // Set the custom failure handler here
        CustomAuthenticationFailureHandler failureHandler = new CustomAuthenticationFailureHandler();
        
        http.cors().and().csrf().disable()
            .authorizeRequests()
                .anyRequest().authenticated()
            .and()
            .addFilter(jwtAuthenticationFilter)
            .addFilterAfter(jwtAuthorisationFilter, BasicAuthenticationFilter.class)
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            // Set the custom failure handler here
            .and()
            .exceptionHandling()
                .authenticationEntryPoint(failureHandler);

        return http.build();
    }
}