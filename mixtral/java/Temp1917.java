import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1917 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorize -> authorize
                .antMatcher("/message/**")
                    .hasAuthority("SCOPE_message:read")
                .anyRequest().authenticated())
            .oauth2ResourceServer()
                .jwt();

        // Add this line to disable CSRF protection in your test configuration
        http.csrf().disable();
    }

    public static void main(String[] args) {
        // This method can be left empty or used to start an application context
    }
}