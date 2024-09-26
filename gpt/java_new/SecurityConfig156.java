import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig156urerAdapter;

@EnableWebSecurity
public class SecurityConfig156 extends WebSecurityConfig156urerAdapter {

    private final AuthenticationManagerBuilder globalAuth;

    @Autowired
    public SecurityConfig156(AuthenticationManagerBuilder auth) {
        this.globalAuth = auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // your existing configureGlobal code using globalAuth instead of auth
    }
}