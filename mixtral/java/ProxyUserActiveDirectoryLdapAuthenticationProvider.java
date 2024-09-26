import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

public class ProxyUserActiveDirectoryLdapAuthenticationProvider extends ActiveDirectoryLdapAuthenticationProvider {

    public ProxyUserActiveDirectoryLdapAuthenticationProvider(String domain, String url) {
        super(domain, url);

        // Set proxy user DN and password
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl(url);
        contextSource.setUserDn("CN=proxyuser,OU=Users,DC=example,DC=com");
        contextSource.setPassword("<PROXY_USER_PASSWORD>");
        contextSource.afterPropertiesSet();

        this.setContextSource(contextSource);
    }

    public static void main(String[] args) {
        ProxyUserActiveDirectoryLdapAuthenticationProvider provider =
                new ProxyUserActiveDirectoryLdapAuthenticationProvider("example.com", "ldap://example.com");
        
        // You can now use the provider to authenticate users
    }
}