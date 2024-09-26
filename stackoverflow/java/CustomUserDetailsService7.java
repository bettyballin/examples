import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Set;
import java.util.HashSet;

public class CustomUserDetailsService7 implements UserDetailsService {

    private MembersDao membersDao;
    private CommonMessages commonMessages;

    public CustomUserDetailsService7(MembersDao membersDao, CommonMessages commonMessages) {
        this.membersDao = membersDao;
        this.commonMessages = commonMessages;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Members members = membersDao.findByEmail(email);
        if (members == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        Role role = members.getRoles();
        if (role != null) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new User(members.getEmail(), members.getPassword(), authorities);
    }
}