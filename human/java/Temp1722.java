import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1722 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Main method does not need to do anything for this configuration
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
          .ignoring()
            .antMatchers("/api/login", "/api/logout");
    }
}