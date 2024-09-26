import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private UserProfileJPARepository profileJPARepository;

    @Autowired
    private UserProfileContainer profileContainer;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = (User) userJpaRepository.findByLogin(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().name());
        UserDetails userDetails = (UserDetails) new SecureUser(
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
}