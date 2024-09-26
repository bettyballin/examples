import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2656 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        Temp2656 app = new Temp2656();
        System.out.println("Spring Security Configuration Applied");
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(HttpMethod.POST, "/users/login");
    }
}