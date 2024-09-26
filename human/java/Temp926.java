import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;

public class Temp926 extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
        Temp926 temp = new Temp926();
        try {
            temp.configure(new HttpSecurity(null, null, null, null, null, null, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        FormLoginConfigurer<HttpSecurity> formLogin = new FormLoginConfigurer<>();
        http.apply(formLogin);
        formLogin.loginPage("/auth/login")
                 .permitAll();
    }
}