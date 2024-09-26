import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfig32urerAdapter;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.authentication.LdapAuthenticationProviderConfigurer;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;

@EnableWebSecurity
public class SecurityConfig32 extends WebSecurityConfig32urerAdapter {

    @Bean
    public DefaultSpringSecurityContextSource contextSource() {
        DefaultSpringSecurityContextSource contextSource = new DefaultSpringSecurityContextSource("ldap://aaa:54389/dc=xxx.com");
        contextSource.setUserDn("bbb");
        contextSource.setPassword("ccc");
        return contextSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        LdapAuthenticationProviderConfigurer<AuthenticationManagerBuilder> ldapAuth = auth.ldapAuthentication()
                .contextSource(contextSource())
                .userSearchBase("").userSearchFilter("(&(uid={0})(objectclass=person)(ums-account-state=OK))");
        ldapAuth.ldapAuthoritiesPopulator(ldapAuthoritiesPopulator());
    }

    public LdapAuthoritiesPopulator ldapAuthoritiesPopulator() {
        return new UmsLdapAuthoritiesPopulator(contextSource());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/main/common**", "/admincare**").hasRole("role.xyz.WebAdmin")
            .and().formLogin().loginPage("/auth/login")
            .failureUrl("/auth/login?error=true")
            .defaultSuccessUrl("/main/common")
            .and().logout().invalidateHttpSession(true)
            .logoutSuccessUrl("/auth/login")
            .logoutUrl("/auth/logout");
    }
}