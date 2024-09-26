import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

public class SecurityConfiguration19 extends WebSecurityConfigurerAdapter {

    private final PersistentTokenRepository persistentTokenRepository;

    public SecurityConfiguration19(PersistentTokenRepository persistentTokenRepository) {
        this.persistentTokenRepository = persistentTokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/sg/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
            .rememberMe()
                .rememberMeParameter("remember-me")
                .tokenRepository(persistentTokenRepository)
                .tokenValiditySeconds(86400 * 30)
                .and()
            .formLogin()
                .loginPage("/login")
                .successForwardUrl("/loginSuccessAjax.html")
                .failureUrl("/UnsuccessfulLoginAjax")
                .permitAll();
    }
}