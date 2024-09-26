import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.http.HttpMethod;

public class Temp2065 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Temp2065 application started.");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/books").hasRole("ADMIN")
            .anyRequest().authenticated();
    }
}