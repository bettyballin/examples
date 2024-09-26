import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1525 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Temp1525 application started.");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Add your custom security configuration here
        http
            .authorizeRequests()
                .anyRequest().authenticated()
            .and()
            .formLogin();
    }
}