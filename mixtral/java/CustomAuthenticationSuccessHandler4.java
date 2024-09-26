import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.net.URI;
import org.springframework.web.util.UriComponentsBuilder;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                // your authorization configurations
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .successHandler(new CustomAuthenticationSuccessHandler())
                .permitAll();
    }
}

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                         Authentication authentication) throws IOException, ServletException {

        String userId = ((UserDetailsImpl) authentication.getPrincipal()).getId();

        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

        // Build your custom URL
        URI locationUri = UriComponentsBuilder
            .fromPath("/users/" + userId).build().toUri();

        redirectStrategy.sendRedirect(request, response, locationUri.toString());
    }
}

class UserDetailsImpl implements UserDetails {
    private String id;

    public String getId() {
        return id;
    }

    // Implement other methods from UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}