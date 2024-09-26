import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2359 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // This main method is just a placeholder and does not execute the Spring Security configuration
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/my/**");
    }
}