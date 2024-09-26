import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp3132 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Application started");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
           .antMatchers("/css/**")
           .antMatchers("/anyThingRequiredByLoginPageToWork/**");
    }
}