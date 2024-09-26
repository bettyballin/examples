import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VUserDetailsService implements AuthenticationUserDetailsService<JwtAuthenticationToken> {

    @Autowired
    UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(VUserDetailsService.class);

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserDetails(JwtAuthenticationToken token) throws UsernameNotFoundException {
        logger.debug("User id: " + token.getName());
        // Verify whether there is an entry for this id in the database.
        User user = userRepository.findByAuxillaryId(token.getName());

        if (user == null)
            throw new UsernameNotFoundException("The user with id " + token.getName() + " not found in database.");

        logger.debug("Obtained user details from db: " + user.toString());
        List<GrantedAuthority> authoritiesList = new ArrayList<>();
        // Get user roles
        List<UserRole> userRoles = user.getUserRoles();
        if (userRoles != null) logger.debug("Number of user roles:" + userRoles.size());

        for (UserRole userRole : userRoles) {
            logger.debug(userRole.getCompositeKey().getRole());
            authoritiesList.add(new SimpleGrantedAuthority(userRole.getCompositeKey().getRole()));
        }

        return new org.springframework.security.core.userdetails.User(token.getName(), "TEMP", authoritiesList);
    }
}

// Assuming these classes exist in your project
class UserRepository {
    User findByAuxillaryId(String auxillaryId) {
        // Implementation here
        return null;
    }
}

class User {
    List<UserRole> getUserRoles() {
        // Implementation here
        return null;
    }

    @Override
    public String toString() {
        // Implementation here
        return super.toString();
    }
}

class UserRole {
    CompositeKey getCompositeKey() {
        // Implementation here
        return null;
    }
}

class CompositeKey {
    String getRole() {
        // Implementation here
        return null;
    }
}