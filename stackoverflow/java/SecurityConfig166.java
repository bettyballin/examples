import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class SecurityConfig166 {
    private static final String STUDENT = "STUDENT"; // Assuming this is defined somewhere else

    public void configureHttpSecurity(HttpSecurity http, AuthenticationManager authManager) throws Exception {
        http
            .csrf().disable()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
            .addFilterBefore(new JwtUserNameAndPasswordAuthFilter(authManager), UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
                .antMatchers("/", "/index.html", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT)
                .anyRequest().authenticated();
    }

    // Assuming JwtUserNameAndPasswordAuthFilter is a valid filter that extends UsernamePasswordAuthenticationFilter
    private class JwtUserNameAndPasswordAuthFilter extends UsernamePasswordAuthenticationFilter {
        public JwtUserNameAndPasswordAuthFilter(AuthenticationManager authManager) {
            super.setAuthenticationManager(authManager);
        }
    }
}