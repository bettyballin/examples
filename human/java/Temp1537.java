import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.authentication.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.authentication.LdapAuthoritiesPopulator;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.authentication.LdapAuthoritiesPopulator;
import org.springframework.security.ldap.authentication.UserDetailsServiceLdapAuthoritiesPopulator;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BaseLdapPathContextSource contextSource() {
        DefaultSpringSecurityContextSource contextSource = new DefaultSpringSecurityContextSource("ldap://aaa:54389/dc=xxx.com");
        contextSource.setUserDn("bbb");
        contextSource.setPassword("ccc");
        return contextSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication()
            .contextSource(contextSource())
            .userSearchBase("")
            .userSearchFilter("(&(uid={0})(objectclass=person)(ums-account-state=OK))")
            .ldapAuthoritiesPopulator(ldapAuthoritiesPopulator());
    }

    @Bean
    public LdapAuthoritiesPopulator ldapAuthoritiesPopulator() {
        return new UmsLdapAuthoritiesPopulator(contextSource());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/main/common**", "/admincare**").hasRole("role.xyz.WebAdmin")
                .and()
                .formLogin()
                .loginPage("/auth/login")
                .failureUrl("/auth/login?error=true")
                .defaultSuccessUrl("/main/common")
                .and()
                .logout()
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/auth/login")
                .logoutUrl("/auth/logout");
    }

    // Define UmsLdapAuthoritiesPopulator class or import it if it's defined elsewhere
    public class UmsLdapAuthoritiesPopulator implements LdapAuthoritiesPopulator {
        private final BaseLdapPathContextSource contextSource;

        public UmsLdapAuthoritiesPopulator(BaseLdapPathContextSource contextSource) {
            this.contextSource = contextSource;
        }

        @Override
        public Collection<? extends GrantedAuthority> getGrantedAuthorities(DirContextOperations userData, String username) {
            // Implement the method to return granted authorities
            return Collections.emptyList();
        }
    }
}