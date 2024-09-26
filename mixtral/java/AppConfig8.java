import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class AppConfig extends WebSecurityConfigurerAdapter {

    @Value("${ad.domain}")
    private String adDomain;

    @Value("${ad.host}")
    private String adHost;

    @Value("${ad.port:389}")
    private int adPort;

    @Bean
    public LdapContextSource contextSource() {
        DefaultSpringSecurityContextSource source = new DefaultSpringSecurityContextSource(
                "ldap://" + adHost + ':' + adPort);
        source.setUserDn("CN=your-service-account,OU=Users," + adDomain);
        source.setPassword("password");
        return source;
    }

    @Bean
    public ActiveDirectoryLdapAuthenticationProvider activeDirectoryAuthProvider() {
        ActiveDirectoryLdapAuthenticationProvider provider =
                new ActiveDirectoryLdapAuthenticationProvider(adDomain, "ldap://" + adHost + ':' + adPort);
        provider.setContextSource(contextSource());
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(activeDirectoryAuthProvider());
    }
}