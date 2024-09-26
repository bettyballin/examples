import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp313 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method content
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // Ignore HTML files
        web.ignoring().antMatchers("/*.html");

        // Set up custom login page
        web.httpBasic().and().authorizeRequests().antMatchers("/login").permitAll()
                .and().formLogin().defaultSuccessUrl("/login").permitAll();
    }
}