import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public final class MyUserDetailsService implements UserDetailsService {
    private final UsersDao usersDao;

    @Autowired
    public MyUserDetailsService(final UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserEntity user = usersDao.getUserByOpenIdIdentifier(username);
        if (user == null) {
            // there is no such user in our db, we could here throw
            // an Exception instead then the user would also be deauthenticated 
            return new User(username, "", new ArrayList<GrantedAuthority>());
        }

        // here we are granting to users roles based on values from db
        final Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getUserType().toString()));

        final UserDetails result = new User(username, "", authorities);

        return result;
    }
}

interface UsersDao {
    UserEntity getUserByOpenIdIdentifier(String username);
}

class UserEntity {
    private String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}