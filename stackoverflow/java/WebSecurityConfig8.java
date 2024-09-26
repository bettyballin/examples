import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig8urerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig8 extends WebSecurityConfig8urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()                                                                
            .antMatchers("/resources/**", "/login").permitAll()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/admin/home")
                .failureUrl("/loginfailed")             
                .permitAll()
            .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
            .and();
    }
}