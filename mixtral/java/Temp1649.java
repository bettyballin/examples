import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1649 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("This is a Spring Security configuration example.");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.DELETE, "/api/**").hasRole("MANAGER")
            .anyRequest().authenticated();
    }
}