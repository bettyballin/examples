import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;

import javax.naming.ldap.LdapName;
import javax.naming.ldap.Rdn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsContextMapper userDetailsContextMapper() {
        return new LdapUserDetailsMapper() {
            @Override
            public UserDetails mapUserFromContext(DirContextOperations ctx, String username,
                                                  Collection<? extends GrantedAuthority> authorities) {
                List<GrantedAuthority> mappedAuthorities = new ArrayList<>();
                for (GrantedAuthority authority : authorities) {
                    if ("memberOf".equals(authority.getAuthority())) {
                        String distinguishedName = (String) ctx.getObjectAttribute("distinguishedName");
                        LdapName ldapName = LdapUtils.newLdapName(distinguishedName);
                        Rdn rdn = ldapName.getRdns().get(0);
                        String groupName = rdn.getValue().toString();
                        mappedAuthorities.add(new SimpleGrantedAuthority(groupName));
                    } else {
                        mappedAuthorities.add(authority);
                    }
                }

                return new User(username, "", true, true, true, true,
                        mappedAuthorities);
            }
        };
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder.ldapAuthentication()
                .userSearchFilter("(sAMAccountName={0})")
                .contextSource().url("ldap://regions.office.ru:389")
                .and()
                .userDetailsContextMapper(userDetailsContextMapper());
    }
}