import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomUserDetailsService9 implements UserDetailsService {

  private final UserRepo userRepo;

  public CustomUserDetailsService9(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepo.findByUserName(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
  }
}