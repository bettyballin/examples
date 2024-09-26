import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecConf extends WebSecurityConfigurerAdapter {

    @Autowired
    PersistentTokenRepository persistenceTokenRepository;

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .rememberMe()
                .tokenRepository(persistenceTokenRepository)
                .rememberMeCookieName("rememberme")
                .tokenValiditySeconds(60 * 60 * 24)
                .alwaysRemember(true)
                .useSecureCookie(true)
                .and()
            .authorizeRequests()
                .anyRequest().authenticated();
    }

    @Bean
    public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices() {
        PersistentTokenBasedRememberMeServices persistenceTokenBasedservice = new PersistentTokenBasedRememberMeServices("rememberme", userDetailsService, persistenceTokenRepository);
        persistenceTokenBasedservice.setAlwaysRemember(true);
        return persistenceTokenBasedservice;
    }
}