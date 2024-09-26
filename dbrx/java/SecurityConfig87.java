import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.DelegatingAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.LinkedHashMap;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/employees/**").authenticated()
            .and()
            .exceptionHandling().authenticationEntryPoint(delegatingAuthenticationEntryPoint());
    }

    private DelegatingAuthenticationEntryPoint delegatingAuthenticationEntryPoint() {
        LinkedHashMap<RequestMatcher, AuthenticationEntryPoint> entryPoints = new LinkedHashMap<>();

        RequestMatcher employeesMatcher = new AntPathRequestMatcher("/employees/**");
        entryPoints.put(employeesMatcher, ldapAuthenticationEntryPoint());

        RequestMatcher customersMatcher = new NegatedRequestMatcher(employeesMatcher);
        entryPoints.put(customersMatcher, databaseAuthenticationEntryPoint());

        DelegatingAuthenticationEntryPoint delegatingEntryPoint = new DelegatingAuthenticationEntryPoint(entryPoints);
        delegatingEntryPoint.setDefaultEntryPoint(new LoginUrlAuthenticationEntryPoint("/default-login"));
        return delegatingEntryPoint;
    }

    private AuthenticationEntryPoint ldapAuthenticationEntryPoint() {
        return new LoginUrlAuthenticationEntryPoint("/ldap-login");
    }

    private AuthenticationEntryPoint databaseAuthenticationEntryPoint() {
        return new LoginUrlAuthenticationEntryPoint("/database-login");
    }
}