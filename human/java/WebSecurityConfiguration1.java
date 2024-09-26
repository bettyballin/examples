import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration1 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/admin/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class)
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().logoutSuccessUrl("/");
    }

    // Placeholder for the SSO filter method
    private BasicAuthenticationFilter ssoFilter() {
        return new BasicAuthenticationFilter(authenticationManager());
    }
}