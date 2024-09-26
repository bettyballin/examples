import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private YourRepository yourRepo;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Retrieve the user object from database using Spring Data JPA
        Optional<YourEntity> optional = this.yourRepo.findById(email);

        if (!optional.isPresent())
            throw new UsernameNotFoundException("User not found");

        YourEntity yourEntity = optional.get();

        // Create a custom user object that implements the Spring Security's UserDetails interface
        CustomUserDetails user = new CustomUserDetails(yourEntity);

        return user;
    }
}

// Example repository interface
import org.springframework.data.repository.CrudRepository;

public interface YourRepository extends CrudRepository<YourEntity, String> {

}

// Example entity class
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class YourEntity {
    
    @Id
    private String email;
    private String password;

    // getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

// Example custom UserDetails class
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private YourEntity yourEntity;

    public CustomUserDetails(YourEntity yourEntity) {
        this.yourEntity = yourEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return authorities if any
        return null;
    }

    @Override
    public String getPassword() {
        return yourEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return yourEntity.getEmail();
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
}