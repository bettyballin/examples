import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp793 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method body
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/error", "/login**").permitAll()
                .anyRequest().authenticated();
    }
}