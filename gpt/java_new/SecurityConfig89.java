import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig89urerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig89 extends WebSecurityConfig89urerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // configure your authentication manager
    }
}

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/springtest")
public class EmployeeController {

    @PreAuthorize("#empId == authentication.principal.id")
    @GetMapping("/{empId}")
    public ModelAndView getEmployeeInfo(@PathVariable Long empId) {
        ModelAndView modelAndView = new ModelAndView("empInfo");
        // Add employee information to the model
        return modelAndView;
    }
}