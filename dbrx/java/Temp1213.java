import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class Temp1213 {

    public static void main(String[] args) {
        // This main method can be used to test the beans if needed
        Temp1213 temp = new Temp1213();
        LdapTemplate ldapTemplate = temp.ldapTemplate();
        System.out.println("LdapTemplate Bean Created: " + ldapTemplate);
    }

    @Bean
    public LdapContextSource contextSource() {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldap://your-ad-server:3268");
        contextSource.setUserDn("CN=YourUser,OU=Users,DC=ah1,DC=ad,DC=megacorp,DC=com");
        contextSource.setPassword("your-password");
        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate(LdapContextSource contextSource) {
        return new LdapTemplate(contextSource);
    }
}