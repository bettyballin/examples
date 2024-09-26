import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig126 {

    // Assuming JwtUsernameAndPasswordFilter and JwtTokenVerifier are already implemented
    private final JwtUsernameAndPasswordFilter jwtUsernameAndPasswordFilter;
    private final JwtTokenVerifier jwtTokenVerifier;

    public SecurityConfig126(JwtUsernameAndPasswordFilter jwtUsernameAndPasswordFilter, JwtTokenVerifier jwtTokenVerifier) {
        this.jwtUsernameAndPasswordFilter = jwtUsernameAndPasswordFilter;
        this.jwtTokenVerifier = jwtTokenVerifier;
    }

    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // other configuration...
            .addFilter(jwtUsernameAndPasswordFilter)
            .addFilterAfter(jwtTokenVerifier, JwtUsernameAndPasswordFilter.class);
        return http.build();
    }
}