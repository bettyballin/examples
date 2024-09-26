import org.springframework.context.annotation.Bean;
import org.springframework.ldap.core.support.LdapContextSource;

public class LdapConfig {

    private String adHost = "localhost"; // replace with your AD host
    private int adPort = 389; // replace with your AD port

    @Bean
    public ContextSource contextSource() {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldap://" + adHost + ":" + adPort);
        contextSource.setBase("");
        contextSource.setUserDn("your-ad-manager-dn");
        contextSource.setPassword("your-ad-manager-password");
        contextSource.afterPropertiesSet(); // Important to initialize the ContextSource
        return contextSource;
    }
}