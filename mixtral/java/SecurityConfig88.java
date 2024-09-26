import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable CORS and disable CSRF
        http.cors().and()
            .csrf().disable();

        // Configure form login
        http
          .authorizeRequests()
              .antMatchers("/login*").permitAll()
              .anyRequest().authenticated()
                .and()
           .formLogin()
             .defaultSuccessUrl("/homepage", true);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // Add allowed origins methods and headers
        CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();

        // Allow credentials
        config.setAllowCredentials(true);

        // Set the configuration for all paths
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}