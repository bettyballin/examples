import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp3181 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSec) throws Exception {
        httpSec
            .authorizeRequests()
            .antMatchers("/users").authenticated()
            .antMatchers("/admin", "/db").hasRole("ADMIN")
            .antMatchers("/**").permitAll()
            .and()
            .csrf().disable()
            .headers().frameOptions().disable();
    }

    public static void main(String[] args) {
        System.out.println("Spring Security configuration applied.");
    }
}