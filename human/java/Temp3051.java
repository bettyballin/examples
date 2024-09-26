import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
public class Temp3051 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        System.out.println("Temp3051 application running...");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests -> 
                authorizeRequests
                    .antMatchers("/**").hasRole("USER")
            )
            .formLogin(withDefaults());
    }
}