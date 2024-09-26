import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp2410 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // The main method generally won't contain security configuration
        System.out.println("Security configuration is set up.");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/test/**")
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin();
    }
}