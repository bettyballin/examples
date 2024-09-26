import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private static final String REGISTER_URL = "/register";

    @Autowired
    public WebSecurity(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, REGISTER_URL).permitAll()
                    .anyRequest().authenticated()
                .and()
                    .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint())
                .and()
                    .addFilter(new JWTAuthenticationFilter(authenticationManager(), tokenProvider()))
                    .addFilter(new JWTAuthorizationFilter(authenticationManager(), tokenProvider()));
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Bean
    public TokenProvider tokenProvider() {
        return new TokenProvider();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint();
    }
}

// Dummy TokenProvider class
class TokenProvider {
    // Implementation details
}

// Dummy JWTAuthenticationFilter class
class JWTAuthenticationFilter extends org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter {
    public JWTAuthenticationFilter(org.springframework.security.authentication.AuthenticationManager authenticationManager, TokenProvider tokenProvider) {
        // Implementation details
    }
}

// Dummy JWTAuthorizationFilter class
class JWTAuthorizationFilter extends org.springframework.web.filter.OncePerRequestFilter {
    public JWTAuthorizationFilter(org.springframework.security.authentication.AuthenticationManager authenticationManager, TokenProvider tokenProvider) {
        // Implementation details
    }

    @Override
    protected void doFilterInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain filterChain) throws java.io.IOException, javax.servlet.ServletException {
        // Implementation details
    }
}

// Dummy CustomAuthenticationEntryPoint class
class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, org.springframework.security.core.AuthenticationException authException) throws java.io.IOException, javax.servlet.ServletException {
        // Implementation details
    }
}