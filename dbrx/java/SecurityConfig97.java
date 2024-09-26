import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.stereotype.Component;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Assuming these services are defined elsewhere in your project
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AppUserService appUserService;

    public SecurityConfig(BCryptPasswordEncoder bCryptPasswordEncoder, AppUserService appUserService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.appUserService = appUserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/api-docs", "/swagger").permitAll()
                .anyRequest().authenticated();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Add a custom filter to handle requests with '/login' in their URL
        CustomLoginFilter loginFilter = new CustomLoginFilter();
        http.addFilterBefore(loginFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(this.bCryptPasswordEncoder);
        provider.setUserDetailsService(this.appUserService);

        return provider;
    }
}

@Component
public class CustomLoginFilter extends OncePerRequestFilter {

    private static final String LOGIN_URL = "/api/vo/auth/login";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
                                    FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().equals(LOGIN_URL)) {
            // Skip authentication for login requests
            System.out.println("@@ CustomLoginFilter: Skipping authentication");
            filterChain.doFilter(request, response);
            return;
        }

        // Proceed with the JWT filter chain for other URLs
        JwtFilter jwtFilter = new JwtFilter();
        jwtFilter.doFilter(request, response, filterChain);
    }
}

// Dummy classes to avoid compilation errors
class BCryptPasswordEncoder implements org.springframework.security.crypto.password.PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }
}

class AppUserService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws org.springframework.security.core.userdetails.UsernameNotFoundException {
        return new org.springframework.security.core.userdetails.User(username, "", new java.util.ArrayList<>());
    }
}

class JwtFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(request, response);
    }
}