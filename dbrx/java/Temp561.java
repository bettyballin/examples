import org.springframework.context.annotation.Bean;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class LdapConfig {

    @Value("${security.ldap.proxy.userOU}")
    private String userOU;

    @Value("${security.ldap.proxy.password}")
    private String password;

    @Bean
    public BindAuthenticator authenticator(DefaultSpringSecurityContextSource contextSource) {
        String managerDn = "CN=" + userOU + ",DC=mydomain,DC=com";

        BindAuthenticator bindAuthenticator = new BindAuthenticator(contextSource);
        bindAuthenticator.setUserDn(managerDn);
        bindAuthenticator.setPassword(password);

        return bindAuthenticator;
    }

    public static void main(String[] args) {
        // This is just a placeholder for the main method if needed.
        System.out.println("LdapConfig loaded successfully.");
    }
}