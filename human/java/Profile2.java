import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Set;

// Profile Entity

@Entity
public class Profile implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Override
    public Set<GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return null; // implement password field and return it here
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // getters and setters for id and name
}

// Role Embeddable

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

    // getters and setters
}

// Profile Repository

interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Profile findByUsername(String username);
}

// Profile Service

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
}