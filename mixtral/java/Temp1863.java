import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1863 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Entry point for the application
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
           .antMatchers("/v1/users/**");
    }
}