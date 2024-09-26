import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Profile implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    // Removed ImmutableSet.of() usage for simplicity
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    // UserDetails methods need to be implemented
    // ...

    // Getters and setters
    // ...
}

@Embeddable
public class Role implements GrantedAuthority {

    public final static Role USER = new Role("USER");
    public final static Role ADMIN = new Role("ADMIN");

    private String authority;

    public Role() {}

    public Role(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    // Getters and setters
    // ...
}

@Transactional
@Service
public class ProfileService implements UserDetailsService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile loadUserByUsername(String username) throws UsernameNotFoundException {
        Profile profile = profileRepository.findByUsername(username);

        if (profile == null) {
            throw new UsernameNotFoundException("security.userNotFound");
        }

        return profile;
    }

    // Additional services
    // ...
}

// Repository not provided in the snippet
interface ProfileRepository {
    Profile findByUsername(String username);
}