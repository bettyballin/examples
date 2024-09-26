import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final KeycloakSpringBootConfigResolver keycloakConfig;

    public SecurityConfig(KeycloakSpringBootConfigResolver keycloakConfig) {
        this.keycloakConfig = keycloakConfig;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        CustomAuthenticationProvider provider = new CustomAuthenticationProvider(keycloakConfig);
        auth.authenticationProvider(provider);
    }
}

class CustomAuthenticationProvider implements AuthenticationProvider {

    private final KeycloakSpringBootConfigResolver keycloakConfig;

    public CustomAuthenticationProvider(KeycloakSpringBootConfigResolver keycloakConfig) {
        this.keycloakConfig = keycloakConfig;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        // Custom authentication logic here
        // For example, you can use the username and password to authenticate with Keycloak
        // Keycloak keycloak = Keycloak.getInstance(keycloakConfig.getKeycloakUrl(), keycloakConfig.getRealm(), username, password, keycloakConfig.getClientId(), keycloakConfig.getClientSecret());
        // if (keycloak.token().get().getAccessToken() != null) {
        //     return new UsernamePasswordAuthenticationToken(username, password, getAuthorities());
        // }

        // For demonstration purposes, assume the user is authenticated if the username and password are not empty
        if (!username.isEmpty() && !password.isEmpty()) {
            return new UsernamePasswordAuthenticationToken(username, password, getAuthorities());
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }
}