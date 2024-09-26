import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp3440 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // Restrict Endpoints
                .antMatchers("/login/**").hasAnyRole("admin", "member")
                // Allow Forms
                .antMatchers("/member/**").permitAll()
                // Allow Resources
                .antMatchers("/js/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .regexMatchers("/.*lang=.*").permitAll()
                // Deny All
                .anyRequest().authenticated();
    }

    public static void main(String[] args) {
        // Spring Boot applications typically use SpringApplication.run to launch the application
        // Since it's a basic Spring Security config, the main method might not be necessary for this setup.
        // However, if you are using Spring Boot, you can have a main method like this:
        // SpringApplication.run(Temp3440.class, args);
    }
}