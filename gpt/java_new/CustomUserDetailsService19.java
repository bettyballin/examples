import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Service
public class CustomUserDetailsService19 implements UserDetailsService {

    @Autowired
    private MembersDao membersDao;

    private static final int MAX_ATTEMPTS = 3;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Members member = membersDao.findByEmail(email);
        if (member == null) {
            throw new UsernameNotFoundException("Invalid username and password.");
        }

        if (member.getAttempts() >= MAX_ATTEMPTS) {
            throw new LockedException("Your account is blocked.");
        }

        Set<SimpleGrantedAuthority> grantedAuthorities = member.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new User(member.getEmail(), member.getPassword(), grantedAuthorities);
    }
}