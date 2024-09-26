import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

@Service
public class AuthService1 implements UserDetailsService {

    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private UserProfileJPARepository profileJPARepository;
    @Autowired
    private UserProfileContainer profileContainer;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userJpaRepository.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().name());
        UserDetails userDetails = new SecureUser(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getMobileNumber(),
                user.getLogin(),
                user.getPassword(),
                user.isActive(),
                true,
                true,
                true,
                Arrays.asList(authority)
        );
        user.setLastLogonTime(new Timestamp((new Date()).getTime()));
        userJpaRepository.saveAndFlush(user);
        profileContainer.setUser(user);
        return userDetails;
    }

    // Assuming SecureUser is a valid UserDetails implementation
    // Assuming User is a valid entity with the required fields
    // Assuming UserJpaRepository and UserProfileJPARepository are valid JPA repositories
}