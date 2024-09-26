import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/Intranet/Bokning").authenticated() // Block this 
            .antMatchers("/**", "/Intranet**").permitAll() // Allow this for all
            .anyRequest().authenticated()
            .and().logout().logoutSuccessUrl("/").permitAll()
            .and()
            .oauth2Login();
    }
}