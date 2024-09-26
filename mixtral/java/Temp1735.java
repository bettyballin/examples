import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1735 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
            .loginPage("/login")
            .failureForwardUrl("/login.html")
            .usernameParameter("username")
            .passwordParameter("password");
    }

    public static void main(String[] args) {
        System.out.println("Spring Security configuration is set!");
    }
}