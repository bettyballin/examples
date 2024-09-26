import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2707 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/logpage")
                .usernameParameter("custom-username-parameter-name");
    }

    public static void main(String[] args) {
        System.out.println("Spring Security Configuration Example");
    }
}