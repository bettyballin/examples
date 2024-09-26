import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.http.HttpStatus;

@EnableWebSecurity
public class SecurityConfig148 {

    private final AuthenticationManager authenticationManager;

    public SecurityConfig148(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return authenticationManager;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager);
        JwtAuthorisationFilter jwtAuthorisationFilter = new JwtAuthorisationFilter();

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
}