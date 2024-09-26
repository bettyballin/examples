import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfiguration21 extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/login*").permitAll() // Allow everyone to access login pages
            .antMatchers("/**").authenticated() // Require authentication for all other URLs
            .and()
            .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/welcome")
                .usernameParameter("username")
                .passwordParameter("password")
            .and()
            .logout()
                .logoutSuccessUrl("/login?logout")
                .logoutUrl("/logout")
            .and()
            .exceptionHandling().accessDeniedPage("/accessDenied")
            .and()
            .csrf();
    }
}