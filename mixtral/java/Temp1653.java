import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1653 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // Entry point for the application
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // Allow all other requests without authentication
                .antMatchers("/**").permitAll()
                // Require ADMIN authority for /admin/** URLs
                .antMatchers("/admin/**")
                    .hasAuthority("ADMIN")
            .and().csrf().disable();
    }
}