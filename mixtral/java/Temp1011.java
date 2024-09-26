import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1011 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/api/**")
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .httpBasic();

        http
            .antMatcher("/**")
            .authorizeRequests()
            .anyRequest().permitAll();
    }

    public static void main(String[] args) {
        System.out.println("Security configuration is set up.");
    }
}