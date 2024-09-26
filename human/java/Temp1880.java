import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1880 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // This is just a placeholder main method to make the class executable.
        System.out.println("Temp1880 application is running.");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/metrics**")
            .antMatchers("/health**")
            .antMatchers("/logfile**")
            .antMatchers("/systemcheck**");
    }
}