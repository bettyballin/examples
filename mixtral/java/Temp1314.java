import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.authentication.LdapShaPasswordEncoder;

public class Temp1314 {
    public static void main(String[] args) {
        // This is a placeholder for testing purposes
        System.out.println("LDAP Configuration Example");
    }

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Replace <your_server> with your actual LDAP server
        DefaultSpringSecurityContextSource context = new DefaultSpringSecurityContextSource("ldap://<your_server>:389/dc=mutualser,dc=org");
        context.afterPropertiesSet(); // Initialize the context

        BindAuthenticator bindAuth = new BindAuthenticator(context);
        
        // Set the user DN pattern
        String USER_DN = "cn={0},ou=users";
        String USERNAME = "cn";
        String username = "testUser";
        UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(username, "password");

        String[] tokens = USER_DN.split(",");

        for (String token : tokens) {
            if (!token.startsWith(USERNAME)) continue;

            bindAuth.setUserDnPatterns(new String[]{token});

            credentials.setDetails("user=" + username);

            break;
        }

        LdapAuthenticationProvider ldapAuthProvider = new LdapAuthenticationProvider(bindAuth);
        ldapAuthProvider.setAuthoritiesMapper(new SimpleAuthoritiesMapper());
        ldapAuthProvider.setUserDetailsContextMapper(new SimpleUserDetailsContextMapper());

        auth
            .authenticationProvider(ldapAuthProvider)
            .ldapAuthentication()
                .userSearchBase("ou=users")
                .userSearchFilter("(uid={0})")
                .groupSearchBase("ou=groups")
                .contextSource(context)
                .passwordCompare()
                .passwordEncoder(new LdapShaPasswordEncoder())
                .passwordAttribute("userPassword");
    }
}