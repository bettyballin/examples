import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public CustomLdapUserDetailsMapper ldapUserDetailsMapper() {
        return new CustomLdapUserDetailsMapper();
    }

    class CustomLdapUserDetailsMapper implements LdapUserDetailsMapper<CustomUser> {

        @Override
        public CustomUser mapFromContext(DirContextOperations ctx) {
            List<String> roles = new ArrayList<>();

            if (ctx.getStringAttributes("memberOf") != null && ctx.getStringAttributes("memberOf").length > 0) {
                for (String role : ctx.getStringAttributes("memberOf")) {
                    roles.add(role);
                }
            }

            return new CustomUser(
                // Assuming CustomUser has a constructor that takes roles as a parameter
                roles
            );
        }
    }

}

class CustomUser {
    private List<String> roles;

    public CustomUser(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}