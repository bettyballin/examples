import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/petclinic/")
                .usernameParameter("j_username") // default is username
                .passwordParameter("j_password") // default is password
                .loginProcessingUrl("/j_spring_security_check") // default is /login with an HTTP post 
                .failureUrl("/login")
                .permitAll()
                .and()
            .logout()
                .logoutSuccessUrl("/index.jsp")
                .and()
            .authorizeRequests()
                .antMatchers("/**").hasRole("ADMIN")
                .antMatchers("/j_spring_security_check").permitAll()
                .and()
            .userDetailsService(userDetailsService);
    }
}