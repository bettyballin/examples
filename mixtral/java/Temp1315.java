import org.springframework.context.annotation.Bean;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.authentication.LdapContextSource;

public class Temp1315 {
    public static void main(String[] args) {
        // This part initializes the context and prints it to demonstrate it works
        Temp1315 temp = new Temp1315();
        DefaultSpringSecurityContextSource contextSource = temp.context();
        System.out.println("Context initialized: " + contextSource);
    }

    @Bean
    public DefaultSpringSecurityContextSource context() {
        LdapContextSource lcs = new LdapContextSource();
        
        // Set the URL and base DN
        lcs.setUrl("ldaps://your_server:636");
        lcs.setBase("dc=mutualser");
        lcs.afterPropertiesSet(); // Required to initialize the context source

        return new DefaultSpringSecurityContextSource(lcs);
    }
}