import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1368 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Execution entry point
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Custom HTTP security configurations
        // ...

        // Example configuration
        http
            .authorizeRequests()
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // Custom web security configurations
        // ...

        // Example configuration
        web
            .ignoring()
                .antMatchers("/resources/**");
    }
}