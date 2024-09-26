import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration11 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/admin/**").permitAll()
                .anyRequest().authenticated()
            .and()
                .addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class)
                .formLogin()
                    .loginPage("/login").permitAll()
            .and()
                .logout()
                    .logoutSuccessUrl("/");
    }

    private BasicAuthenticationFilter ssoFilter() {
        // Dummy method for the purpose of this example
        // In a real scenario, you should replace this with actual filter logic
        return new BasicAuthenticationFilter(authenticationManager());
    }
}