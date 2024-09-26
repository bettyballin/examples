import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1767 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/secure/**").access("hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and()
            .requiresChannel()
                .anyRequest().requiresSecure();
    }

    public static void main(String[] args) {
        System.out.println("Security configuration applied.");
    }
}