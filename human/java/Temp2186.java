import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2186 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // This main method is not necessary for the WebSecurityConfigurerAdapter
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "/path/to/skip/check").permitAll()
            .anyRequest().authenticated();
    }
}