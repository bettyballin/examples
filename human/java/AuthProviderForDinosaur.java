import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthProviderForDinosaur implements AuthenticationProvider {

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    List<GrantedAuthority> grantedAuths = new ArrayList<>();
    grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
    return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), grantedAuths);
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
  }
}