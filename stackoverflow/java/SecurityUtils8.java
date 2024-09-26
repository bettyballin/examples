import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtils8 {

  public static boolean hasAuthority(UserDetails user, String... authorities) {
    if (user != null) {
      return user.getAuthorities().stream()
          .map(GrantedAuthority::getAuthority)
          .anyMatch(a -> Arrays.asList(authorities).contains(a));
    }

    return false;
  }
}