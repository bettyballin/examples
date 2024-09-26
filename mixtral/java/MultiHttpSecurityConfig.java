import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class MultiHttpSecurityConfig {

    @Autowired
    private CasAuthenticationProvider casAuthProvider;

    // This config will handle /health/** URLs
    @Bean
    public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {
        return http
            .securityMatcher("/health/**")
                .authorizeHttpRequests()
                    .anyRequest().permitAll()
                    // If you want to restrict detailed health status use the following line instead
//                   .mvcMatchers(HttpMethod.GET, "/actuator/health").hasRole("ADMIN")
                .and()
            .httpBasic()
        .and().build();
    }

    // This config will handle all other URLs
    @Bean
    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {
         return http
             .authorizeHttpRequests().anyRequest().authenticated()
                .and()
            .csrf().disable()
         .build();

        // Add your CAS configuration here
        // auth.inMemoryAuthentication()
        //     .withUser("user").password(passwordEncoder().encode("pass")).roles("USER");
    }
}