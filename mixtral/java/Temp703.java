import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp703 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        // This main method is just a placeholder and does not execute any security configuration
        System.out.println("Temp703 class executed.");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/resources/js/**", "/resources/css/**", "/resources/img/**", "/resources/fonts/**");
    }
}