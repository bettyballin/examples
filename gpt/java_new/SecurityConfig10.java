import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig10urerAdapter;
import org.springframework.security.authentication.AuthenticationManager;

@EnableWebSecurity
public class SecurityConfig10 {

    @Configuration
    @Order(1)
    public static class ExternalWebSecurityConfig10urationAdapter extends WebSecurityConfig10urerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/external/**")
                .authorizeRequests(authorize -> authorize
                    .anyRequest().authenticated()
                )
                .formLogin()
                .and();
        }

        @Bean
        public AuthenticationManager authenticationManager2() throws Exception {
            return super.authenticationManagerBean();
        }
    }

    @Configuration
    public static class DefaultWebSecurityConfig10urerAdapter extends WebSecurityConfig10urerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests(authorize -> authorize
                    .anyRequest().authenticated()
                )
                .formLogin()
                .and();
        }
        
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            // Define your userDetailsService and/or authenticationProvider here
        }
    }
}