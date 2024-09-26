import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp3424 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // Execution starts here
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/ws/persons/createNotificationsSubscriber*").permitAll();
    }
}