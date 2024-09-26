import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.ldap.authentication.LdapAuthenticationProviderConfigurer;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;

// Assuming the contextSource() and authoritiesMapper() methods are defined elsewhere
// in your configuration, they need to be imported or defined in this code snippet.

public class SecurityConfig108 {

    private final GrantedAuthoritiesMapper authoritiesMapper;

    @Autowired
    public SecurityConfig108(GrantedAuthoritiesMapper authoritiesMapper) {
        this.authoritiesMapper = authoritiesMapper;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        LdapAuthenticationProviderConfigurer<AuthenticationManagerBuilder>.ContextSourceBuilder contextSourceBuilder =
                auth.ldapAuthentication()
                        .userSearchBase("ou=users")
                        .userSearchFilter("(cn={0})")
                        .groupSearchBase("ou=groups")
                        .groupSearchFilter("(member={0})")
                        .groupRoleAttribute("cn");

        if (contextSource() != null) {
            contextSourceBuilder.contextSource(contextSource());
        }

        if (authoritiesMapper != null) {
            contextSourceBuilder.authoritiesMapper(authoritiesMapper);
        }
    }

    // Dummy methods for compilation, should be implemented as per application context
    private Object contextSource() {
        return null;
    }
}