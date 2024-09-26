import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig155urerAdapter;
import org.springframework.security.config.annotation.SecurityConfig155urerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
public class SecurityConfig155 extends WebSecurityConfig155urerAdapter {

    @Autowired
    private CsrfSecurityConfig155urer csrfSecurityConfig155urer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.apply(csrfSecurityConfig155urer);
    }
}

public class CsrfSecurityConfig155urer extends AbstractHttpConfigurer<CsrfSecurityConfig155urer, HttpSecurity> {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            );
    }
}