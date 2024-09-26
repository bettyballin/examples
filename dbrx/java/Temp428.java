import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.RememberMeAuthenticationToken;

@SpringBootApplication
public class Temp428 {
    public static void main(String[] args) {
        SpringApplication.run(Temp428.class, args);
    }
}

@Configuration
static class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.rememberMe().rememberMeCookieName("remember-me");
    }
}

@Controller
class SignInController {

    @GetMapping("/signin")
    public String signin(Model model, @CookieValue(value = "remember-me", required = false) String rememberMe) {
        if (SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication() instanceof RememberMeAuthenticationToken) {
            return "redirect:/home";
        }
        
        // Display login form.
        return "signin";
    }
}