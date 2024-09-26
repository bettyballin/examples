import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class Temp843 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
                .ignoringAntMatchers("/p/paysera/**")
            .and()
            .authorizeRequests()
                .anyRequest().authenticated();
    }

    public static void main(String[] args) {
        System.out.println("Application started");
        // Application context initialization code would go here
    }
}