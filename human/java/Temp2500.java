import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp2500 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        // The main method would typically start the Spring application context, 
        // but for simplicity, we are not doing it here.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.anonymous().disable();
    }
}