import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig {

    @Configuration
    @Order(1)
    public static class BasicAuthenticationConfig {

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            // Configure basic authentication
        }

        @Bean
        public SecurityFilterChain filterChainBasicAuth(HttpSecurity http) throws Exception {
            return http
                    .antMatcher("/api/v1/**")
                    .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .httpBasic()
                    .and()
                    .build();
        }
    }

    @Configuration
    @Order(2)
    public static class TokenAuthenticationConfig {

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            // Configure token-based authentication
        }

        @Bean
        public SecurityFilterChain filterChainTokenAuth(HttpSecurity http, MyCustomFilter myCustomFilter) throws Exception {
            return http
                    .antMatcher("/api/v2/**")
                    .addFilterBefore(myCustomFilter, UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .build();
        }
    }
}

// Assuming MyCustomFilter is defined elsewhere in your codebase, for example:
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyCustomFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Custom filter logic
        filterChain.doFilter(request, response);
    }
}