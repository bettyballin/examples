import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Temp2219 extends WebSecurityConfigurerAdapter {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/home", true)
                .and()
            .logout()
                .permitAll();
    }

    public static void main(String[] args) {
        // Spring Boot application entry point
        org.springframework.boot.SpringApplication.run(Temp2219.class, args);
    }
}