import org.springframework.context.annotation.Bean;
import org.springframework.ldap.core.support.LdapContextSource;

public class Temp1892 {
    public static void main(String[] args) {
        Temp1892 temp = new Temp1892();
        LdapContextSource source = temp.ldapContextSource();
        // Use the source object as needed
    }

    @Bean
    public LdapContextSource ldapContextSource() {
        LdapContextSource source = new LdapContextSource();
        // Set the URL of your LDAP server
        source.setUrl("ldap://your-ldap-server-url");
        source.setBase("dc=example,dc=com"); // Set the base DN
        source.setUserDn("cn=admin,dc=example,dc=com"); // Set the user DN
        source.setPassword("password"); // Set the password
        source.afterPropertiesSet(); // Initialize the context source
        return source;
    }
}