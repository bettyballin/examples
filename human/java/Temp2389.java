import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2389 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // This main method will not do anything useful in this context 
        // since the web security configuration is typically handled by the Spring Framework.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/favicon.ico", "*.css").permitAll()
            .anyRequest().authenticated();
    }
}