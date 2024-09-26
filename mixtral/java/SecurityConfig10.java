import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public static class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);

        DefaultRolesPrefixPostProcessor rolesPrefix = new DefaultRolesPrefixPostProcessor();

        // Use an empty string as a custom role prefix
        rolesPrefix.setRolePrefix("");

        auth.apply(rolesPrefix);
    }

    private static class DefaultRolesPrefixPostProcessor {
        private String rolePrefix = "ROLE_";

        public void setRolePrefix(String rolePrefix) {
            this.rolePrefix = rolePrefix;
        }

        public String getRolePrefix() {
            return rolePrefix;
        }
    }
}