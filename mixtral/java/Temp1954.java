import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

@EnableWebSecurity
public class Temp1954 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Entry point of the application
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/welcome", "/inventory/**", "/sales/**")
                .access(new WebExpressionAuthorizationManager("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')"))
                // OR
                .antMatchers("/welcome", "/inventory/**", "/sales/**")
                .authenticated();
    }
}