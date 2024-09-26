import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

public class SecurityConfiguration17 extends WebSecurityConfigurerAdapter {

    private AuthenticationEntryPoint authenticationEntryPoint;
    private PersistentTokenRepository persistentTokenRepository;

    public SecurityConfiguration17(AuthenticationEntryPoint authenticationEntryPoint,
                                 PersistentTokenRepository persistentTokenRepository) {
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.persistentTokenRepository = persistentTokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").access("hasRole('ADMIN') or hasRole('USER')")
                .antMatchers("/sg/**").hasRole("USER")
                .and().rememberMe().rememberMeParameter("remember-me").tokenRepository(persistentTokenRepository).tokenValiditySeconds(86400 * 30) // 30 days
                .and().formLogin().successForwardUrl("/loginSuccessAjax.html").failureForwardUrl("/UnsuccessfulLoginAjax")
                .and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
    }

    public PersistentTokenRepository persistentTokenRepository() {
        // implementation of persistent token repository
        return null; // placeholder for actual implementation
    }

    // getters and setters for authenticationEntryPoint and persistentTokenRepository
}