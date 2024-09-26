import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class Temp1086 extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/", "/home").permitAll() 
            .antMatchers("/admin/**").hasAuthority("ADMIN")
            .anyRequest().authenticated() 

            .and().csrf().disable()

            .formLogin()
                .loginPage("/adminlogin")
                .failureUrl("/adminlogin?error=true")
                .defaultSuccessUrl("/admin/dashboard", true) 
                .usernameParameter("email")
                .passwordParameter("password")

            .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/adminlogin?logout=true").permitAll() 

            .and().exceptionHandling()
                .accessDeniedPage("/accessdenied");
    }
}