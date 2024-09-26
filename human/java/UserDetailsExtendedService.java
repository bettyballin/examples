import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsExtendedService implements UserDetailsService {
    @Autowired
    private UsersDAO usersDao;

    private UserDetails prepare(com.data.User user) {
        boolean enabled = user.getState().equals(UserState.Active);

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // Assuming a method getRolesForUser exists to replace the /*CALL TO WEB-SERVICE*/
        List<UserRole> roles = getRolesForUser(user);
        for (UserRole r : roles) {
            authorities.add(new SimpleGrantedAuthority(r.getName()));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), 
                user.getPassword(), 
                enabled, 
                true, 
                true, 
                true, 
                authorities);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String email)
            throws UsernameNotFoundException, DataAccessException {
        com.data.User user = usersDao.getByEmail(email);
        if (user == null)
            throw new UsernameNotFoundException(email);

        return prepare(user);
    }

    // Placeholder for the method to fetch roles for a user
    private List<UserRole> getRolesForUser(com.data.User user) {
        // Implement the logic to fetch roles, possibly from a web service or database
        return new ArrayList<>();
    }
}