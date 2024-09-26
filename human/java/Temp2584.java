import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2584 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // This main method doesn't serve a purpose in this context.
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL);
    }
}

class SecurityConstants {
    public static final String SIGN_UP_URL = "/signup";
}