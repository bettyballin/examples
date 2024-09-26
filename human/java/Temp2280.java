import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2280 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Temp2280 Application Started");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // inner codes
        http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .httpBasic();
    }
}