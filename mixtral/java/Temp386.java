import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp386 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method content here
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().access("hasRole('ROLE_USER') and @webExpressionRoot.checkAccountId(authentication.principal.accountId)");
    }
}