import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp1710 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/custom-login")
                .and()
            .formLogin()
                .loginPage("/admin-login");
    }

    public static void main(String[] args) {
        System.out.println("This is just a demonstration of the configure method.");
    }
}