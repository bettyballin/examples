import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.servlet.Filter;

@Configuration
public class FrameworkWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    Filter reallyImportantFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Add your filter here before the authorizeRequests() method.
        http.requestMatchers()
            .mvcMatchers("/forgottenFilter/**")
            .and()
            .addFilterBefore(reallyImportantFilter, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
            .anyRequest().authenticated();
    }
}