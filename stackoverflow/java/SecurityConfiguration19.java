import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration19 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
            .antMatchers("/register", "/javax.faces.resource/**").permitAll()
            .antMatchers("/**").authenticated()
            .and().formLogin().loginPage("/login").permitAll()
            .usernameParameter("username").passwordParameter("password")
            .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }
}