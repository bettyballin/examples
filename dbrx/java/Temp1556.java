import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1556 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            // Restrict Endpoints
            .antMatchers("/login/**").hasAnyRole("admin", "member")

            // Allow Forms
            .antMatchers("/member/**").permitAll()

            // Allow Resources
            .antMatchers("/js/**").permitAll()
            .antMatchers("/css/**").permitAll()

            // Trick to allow Internationalization with regex pattern matching for language parameter in URL
            .regexMatchers("^\\?lang=[a-zA-Z]{2}$").permitAll()

            // Deny All
            .anyRequest().authenticated();
    }

    public static void main(String[] args) {
        // Spring Boot application would typically be started here
    }
}