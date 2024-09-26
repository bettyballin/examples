import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("test".equalsIgnoreCase(username)) {
            return new org.springframework.security.core.userdetails.User("test", "test", getAuthorities(1));
        } else {
            throw new UsernameNotFoundException("Username not found");
        }
    }

    /**
     * Retrieves a collection of {@link GrantedAuthority} based on numerical role
     */
    public Collection<GrantedAuthority> getAuthorities(Integer role) {
        List<String> roles = getRoles(role);
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    /**
     * Converts a numerical role to an equivalent list of roles
     */
    public List<String> getRoles(Integer role) {
        if (role == null || !rolesMap.containsKey(role))
            throw new IllegalArgumentException("Invalid Role");

        return Arrays.asList(rolesMap.get(role));
    }

    private static final Map<Integer, String[]> rolesMap = Map.of(
            1, new String[]{"ROLE_USER", "ROLE_ADMIN"},
            2, new String[]{"ROLE_USER"}
    );
}