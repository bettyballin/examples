import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp468 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Your main method logic here
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll()
            .and()
            .formLogin();
    }
}