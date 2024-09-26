import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2708 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // This is just a placeholder for the main method, 
        // as the real configuration happens in the overridden configure method
        System.out.println("Spring Security Configuration");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().disable();
        http.logout().disable();
    }
}