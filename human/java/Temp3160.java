import org.springframework.context.annotation.Bean;
import org.springframework.security.ldap.userdetails.LdapUserDetailsManager;
import org.springframework.security.ldap.userdetails.UserDetailsManager;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

public class Temp3160 {
    public static void main(String[] args) {
        Temp3160 temp = new Temp3160();
        UserDetailsManager manager = temp.getUserDetailsManager();
        System.out.println("UserDetailsManager Bean has been created: " + manager);
    }

    @Bean("adUserDetailsManager")
    public UserDetailsManager getUserDetailsManager() {
        String providerUrl = "your ldap url here";
        DefaultSpringSecurityContextSource contextSource = new DefaultSpringSecurityContextSource(providerUrl);
        contextSource.afterPropertiesSet();
        return new LdapUserDetailsManager(contextSource);
    }
}