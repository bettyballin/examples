import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableWebSecurity
public class MyApplication extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/secure").hasRole("USER")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .logout().permitAll();
    }

    @Bean
    public MyController myController() {
        return new MyController();
    }
}

@Controller
class MyController {
    @Secured("ROLE_USER")
    @RequestMapping("/secure")
    public String secure() {
        return "secure";
    }
}