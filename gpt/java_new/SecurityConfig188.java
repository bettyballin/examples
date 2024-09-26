import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig188urerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig188 {

    @Configuration
    @Profile("prod") // Only active for production profile
    public static class ProdWebSecurityConfig188 extends WebSecurityConfig188urerAdapter {
        // ... your production security configuration
    }

    @Configuration
    @Profile({"dev", "stage"}) // Only active for development and staging profiles
    public static class NonProdWebSecurityConfig188 extends WebSecurityConfig188urerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .authorizeRequests()
                    .anyRequest().permitAll();
        }
    }
}