import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp494 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Your main method implementation here
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/api/auth-info").denyAll()
                .anyRequest().authenticated();
    }
}