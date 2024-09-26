import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp2129 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        System.out.println("Security configuration loaded");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                // Disable basic authentication for /registration
                .antMatchers("/registration").permitAll()
                // Enable basic auth for all other requests
                .anyRequest().authenticated()
                .and()
            .httpBasic();
    }
}