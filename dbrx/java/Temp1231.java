import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class Temp1231 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Your main logic here
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/api/**")
            // Allow only users with role "ROLE_API"
            .authorizeRequests()
                .antMatchers("/api/v1/notifications").permitAll()
                .anyRequest().hasRole("API")
            .and()
            .httpBasic()
            .and()
            .anonymous()  
            .and()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .csrf().disable();
    }
}