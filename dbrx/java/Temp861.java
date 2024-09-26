import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableWebSecurity
public class Temp861 extends WebSecurityConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(Temp861.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().fullyAuthenticated()
                .and()
                .httpBasic();
    }
}

@Controller
class MyController {
    @RequestMapping(value = "/secured", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public String securedPage(ModelMap model) {
        model.addAttribute("message", "This is a secured page!");
        return "secured";
    }
}