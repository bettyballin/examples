import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp1547 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // This main method is not necessary for Spring Security configuration,
        // but it can be used to start a Spring application if needed.
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
           .antMatchers("/other-resources/**");
    }
}