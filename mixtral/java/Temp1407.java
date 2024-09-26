import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1407 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Spring Boot application would typically be started here
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Disable CSRF protection
        http.csrf().disable()
            .authorizeRequests()
                // Permit access to any request
                .antMatchers("/**").permitAll();

         // Secure swagger's URL
         http
             .antMatcher("/swagger*/**")
                 .httpBasic()
                     .and().authorizeRequests().anyRequest().authenticated();
    }
}