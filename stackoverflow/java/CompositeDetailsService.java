import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.List;

public class CompositeDetailsService implements UserDetailsService {

  private final List<UserDetailsService> services;

  public CompositeDetailsService(List<UserDetailsService> services) {
    this.services = services;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    for (UserDetailsService service : services) {
      try {
        return service.loadUserByUsername(username);
      } catch (UsernameNotFoundException ex) {
        // Continue to next service if user is not found
      }
    }
    throw new UsernameNotFoundException("User with username '" + username + "' not found in any services.");
  }
}