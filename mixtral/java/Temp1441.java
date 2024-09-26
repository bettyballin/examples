import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1441 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Spring Security Configuration");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // ... other configurations

        http
            .authorizeRequests()
                .antMatchers("/user/signup").permitAll();
    }

    // Remove the antMatcher for "/user/signup" from your WebSecurity.ignoring().
}