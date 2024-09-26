import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1054 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Entry point for the application
        System.out.println("Temp1054 application started");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/", "/resources/**")
            .permitAll();

        // Add your role-based authorization rules here
    }
}