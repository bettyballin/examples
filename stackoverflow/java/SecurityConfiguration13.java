import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration13 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .sessionManagement()
                .maximumSessions(1)
                .expiredUrl("/")
                .and()
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/security/checkpoint/for/admin/**").hasRole("ADMIN")
                .antMatchers("/rest/users/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/")
                .defaultSuccessUrl("/welcome")
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout")
                .and()
            .exceptionHandling()
                .accessDeniedPage("/page_403");
    }
}