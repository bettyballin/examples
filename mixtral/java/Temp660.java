import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp660 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        System.out.println("Security configuration loaded.");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/**").hasRole("USER")
                .and()
            .httpBasic()
            .and()
            .csrf().disable();
    }
}