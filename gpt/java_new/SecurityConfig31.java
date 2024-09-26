import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig31urerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig31 extends WebSecurityConfig31urerAdapter {

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // other configurations
            .sessionManagement()
            .maximumSessions(1)
            .sessionRegistry(sessionRegistry());
    }
}

@Controller
public class SessionController {

    @Autowired
    private SessionRegistry sessionRegistry;

    @RequestMapping(value = "/logoutSession", method = RequestMethod.POST)
    public String logoutSession(@RequestParam("sessionId") String sessionId, HttpServletRequest request) {
        // Implementation of logoutSession
        return "redirect:/login?logout";
    }
}