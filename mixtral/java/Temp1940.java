import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1940 extends WebSecurityConfigurerAdapter {
    private static final String[] DEFAULT_IGNORE_REQUESTS = {"/ignore1", "/ignore2"};

    public static void main(String[] args) {
        // Application entry point
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // Ignore the specified paths
        for (String path : DEFAULT_IGNORE_REQUESTS) {
            web.ignoring().antMatchers(path);
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .anyRequest().authenticated();
    }
}