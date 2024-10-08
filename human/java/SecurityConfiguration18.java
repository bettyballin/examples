import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();

        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        source.registerCorsConfiguration("/**", config);

        http.csrf()

            // Disabling CSRF
            .disable()

            // Disabling Session Management
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.NEVER)
            .and()

            // Adding spring-web CORS filter
            .addFilterBefore(new CorsFilter(source), LogoutFilter.class)

            // Adding custom REST Authentication filter
            .addFilterBefore(new RestAuthenticationFilter(authenticationManager()), LogoutFilter.class)

            // Authorizing requests
            .authorizeRequests()
            .antMatchers("/", "/frontend/login")
            .permitAll()
            .antMatchers("/api/**", "/frontend/**")
            .authenticated()
            .antMatchers("/**")
            .permitAll();
    }
}