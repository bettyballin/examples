import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1659 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("This is a Spring Security configuration class.");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers("/resources/**", "/VAADIN/**");
    }
}