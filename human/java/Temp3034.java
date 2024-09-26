import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Temp3034 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Temp3034 application started.");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.anonymous().authorities("ANONYMOUS"); // or your custom role
    }
}