import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.LdapUserDetailsService;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import java.util.Set;

public class Temp1882 {
    public static void main(String[] args) {
        LdapContextSource contextSource = new DefaultSpringSecurityContextSource("ldap://localhost:389");
        ((DefaultSpringSecurityContextSource) contextSource).setUserDn("cn=admin,dc=example,dc=com");
        ((DefaultSpringSecurityContextSource) contextSource).setPassword("password");
        contextSource.afterPropertiesSet();

        AuthenticationManagerBuilder auth = new AuthenticationManagerBuilder(null);
        
        try {
            auth
                .ldapAuthentication()
                .ldapAuthoritiesPopulator(new DefaultLdapAuthoritiesPopulator(contextSource, "OU=Account Groups,OU=ITS Security") {

                    @Override
                    public Set<GrantedAuthority> getGroupMembershipRoles(String userDn, String username) {
                        Set<GrantedAuthority> groupMembershipRoles = super.getGroupMembershipRoles(userDn, username);

                        boolean isMemberOfSpecificAdGroup = false;
                        for (GrantedAuthority grantedAuthority : groupMembershipRoles) {

                            if ("ROLE_AD-this-is-a-specific-group".equals(grantedAuthority.toString())) {
                                isMemberOfSpecificAdGroup = true;
                                break;
                            }
                        }

                        if (!isMemberOfSpecificAdGroup) {
                            throw new BadCredentialsException("User must be a member of " + "AD-this-is-a-specific-group");
                        }
                        return groupMembershipRoles;
                    }
                })
                .userSearchFilter("(cn={0})")
                .groupSearchBase("OU=Account Groups,OU=ITS Security")
                .groupSearchFilter("(member={0})")
                .contextSource(contextSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}