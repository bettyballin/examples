import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Set;
import java.util.HashSet;

public class CustomUserDetailsService8 implements org.springframework.security.core.userdetails.UserDetailsService {

    private MembersDao membersDao; // Assume MembersDao is an interface with findByEmail method

    private static final int MAX_ATTEMPTS = 3;
   
    @Override
    public UserDetails loadUserByUsername(String email) {
        Members members = membersDao.findByEmail(email);
        if (members == null || members.getAttempts() > MAX_ATTEMPTS) {
            return null;
        }
        if (members.getPassword().equals(enteredPassword)) {
            Set<GrantedAuthority> authorities = new HashSet<>();
            for (Role role : members.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getRole()));
            }
            members.setAttempts(0);
            membersDao.save(members);
            return new User(members.getEmail(), members.getPassword(), authorities);
        } else {
            members.setAttempts(members.getAttempts() + 1);
            membersDao.save(members);
            return null;
        }
    }
    
    // Additional methods and fields are assumed to be here, such as the Members and Role class definitions,
    // as well as the membersDao bean initialization.
}