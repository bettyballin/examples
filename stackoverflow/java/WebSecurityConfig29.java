import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig29urerAdapter;

@EnableWebSecurity
public class WebSecurityConfig29 extends WebSecurityConfig29urerAdapter {

    public static class SecurityConstants {
        public static final String SIGN_UP_URL = "/signup";
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL);
    }
}