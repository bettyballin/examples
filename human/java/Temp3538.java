import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@EnableWebSecurity
public class SecurityConfig {

    private final AuthenticationConfiguration authenticationConfiguration;

    public SecurityConfig(AuthenticationConfiguration authenticationConfiguration) {
        this.authenticationConfiguration = authenticationConfiguration;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        AuthenticationManager authenticationManager = authenticationConfiguration.getAuthenticationManager();
        var jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager);

        var jwtAuthorisationFilter = new JwtAuthorisationFilter();

        http.cors().and().csrf().disable().authorizeRequests()
            .anyRequest().authenticated().and()
            .addFilter(jwtAuthenticationFilter)
            .addFilterAfter(jwtAuthorisationFilter, BasicAuthenticationFilter.class)
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .exceptionHandling()
            .accessDeniedHandler((request, response, exception) ->
                response.sendError(HttpStatus.UNAUTHORIZED.value(), exception.getMessage())
            );

        return http.build();
    }

    // Placeholder classes for JwtAuthenticationFilter and JwtAuthorisationFilter
    public class JwtAuthenticationFilter extends BasicAuthenticationFilter {
        public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
            super(authenticationManager);
        }

        // Implement necessary methods here
    }

    public class JwtAuthorisationFilter extends BasicAuthenticationFilter {
        public JwtAuthorisationFilter() {
            super(null); // Placeholder, provide appropriate constructor
        }

        // Implement necessary methods here
    }
}