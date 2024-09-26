import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerBuilder;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.RoleVoter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        // Ignore any request that matches this ant pattern
        web.ignoring().antMatchers("/resources/**");
    }

    // ...

    protected <T extends HttpSecurity> T customizeHttpSecurity(
            final T http,
            final AuthenticationManager authenticationManager) throws Exception {

        // @formatter:off
        return http
                .authorizeRequests()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // ...

        RoleVoter roleVoter = new RoleVoter();

        GrantedAuthorityDefaults grantedAuthorityDefaults =
            (GrantedAuthorityDefaults) DefaultWebSecurityExpressionHandler.getDefault().getRoleHierarchy();

        if (!grantedAuthorityDefaults.isUsePrefix()) {
            roleVoter.setRolePrefix("");

            auth.authenticationProvider(new AuthenticationProvider() {

                @Override
                public boolean supports(Class<?> authentication) {
                    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
                }

                @Override
                public Authentication authenticate(
                        final Authentication authRequest) throws AuthenticationException {
                    // Implement your authentication logic here
                    return null;
                }
            });
        }
    }
}