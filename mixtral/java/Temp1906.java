import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1906 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Temp1906 application started.");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            // Permit file uploads
            .authorizeRequests().antMatchers("/upload").permitAll();
    }
    // Make sure to replace "/upload" with your actual endpoint
}