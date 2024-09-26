import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp2361 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            // These are accessible to all
            .antMatchers("/", "/registration/**", "/view/**").permitAll()
            // These require USER or ADMIN role
            .antMatchers("/new/**", "/edit/**", "/create/**", "/save/**")
                .hasAnyRole("USER", "ADMIN")
            // This requires the ADMIN role
            .anyRequest().authenticated();
    }

    public static void main(String[] args) {
        // Your application logic here
    }
}