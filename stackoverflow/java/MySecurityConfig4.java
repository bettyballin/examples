import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MySecurityConfig4 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/", "index", "login", "/resource/**").permitAll()
            .antMatchers("/userpage").hasRole("USER")
            .and()
            .formLogin()
            .loginPage("/myLoginPage")
            .loginProcessingUrl("/authenticateTheUser")
            .defaultSuccessUrl("/myFirstPage", true)
            .permitAll()
            .and()
            .logout()
            .permitAll();
    }
}