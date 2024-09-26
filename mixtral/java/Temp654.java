import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp654 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/oauth2/authorization/my-client")
                // replace "my-client" with your client id
                .permitAll();
    }

    public static void main(String[] args) {
        System.out.println("Temp654 application starting...");
    }
}