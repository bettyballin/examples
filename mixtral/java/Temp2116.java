import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2116 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // The main method can be used to run the application if required
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/chores");
    }
}