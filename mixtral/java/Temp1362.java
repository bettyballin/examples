import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.http.HttpMethod;

public class Temp1362 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Configured Security");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(HttpMethod.PUT, "/api/**/action/**").access("hasAnyRole('View_accountSearch_account')");
            // Add other configurations here
    }
}