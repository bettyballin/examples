import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsExtendedService implements UserDetailsService {
    
    @Autowired
    private UsersDAO usersDao;
    
    private UserDetails prepare(com.data.User user) {
        boolean enabled = user.getState().equals(UserState.Active);
        
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // Assuming getUserRoles is a web service call method returning a collection of UserRole
        for (UserRole r : getUserRoles()) {
            authorities.add(new SimpleGrantedAuthority(r.getName()));
        }
        
        return new org.springframework.security.core.userdetails.User(
            user.getEmail(),
            user.getPassword(),
            enabled,
            true,
            true,
            true,
            authorities
        );
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String email)
            throws UsernameNotFoundException {
        com.data.User user = usersDao.getByEmail(email);
        if (user == null)
            throw new UsernameNotFoundException(email);
        
        return prepare(user);
    }
    
    private Collection<UserRole> getUserRoles() {
        // Mock method to represent the CALL TO WEB-SERVICE
        // In actual implementation, we should replace this with the real web service call
        return new ArrayList<>();
    }
}