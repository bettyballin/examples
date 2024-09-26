import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp3009 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // This main method is not necessary for a Spring Security configuration class,
        // but since it is requested, it will remain here as an entry point.
        System.out.println("Temp3009 application started.");
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/**");
    }
}