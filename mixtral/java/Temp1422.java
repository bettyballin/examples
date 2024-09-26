import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1422 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // This is just a placeholder main method.
        // In a real Spring Boot application, the Spring framework would handle the application start.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.anonymous().and()
            .authorizeRequests()
            .antMatchers("/experiences").hasRole("ADMIN");
    }
}