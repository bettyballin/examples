import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig110urerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.http.HttpMethod;

public class SecurityConfig110 extends WebSecurityConfig110urerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/images/**", "/fonts/**", "/videos/**")
                .permitAll()
            .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/login").permitAll()
            .and()
                .authorizeRequests()
                .antMatchers("/", "/join", "/about", "/contact", "/index.html")
                .permitAll()
            .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated()
            .and()
                .exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/"));
    }
}