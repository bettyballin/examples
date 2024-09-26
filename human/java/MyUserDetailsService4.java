import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import javax.persistence.PersistenceContextType;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
    
    public void setEntityManager(EntityManager newEm) {
        this.entityManager = newEm;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return entityManager.createQuery("from User where username = :username", User.class)
                            .setParameter("username", username)
                            .getSingleResult();
    }
}

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    private String username;
    private String password;
    private boolean enabled;

    // other fields, getters and setters

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // return the authorities
        return null; // Implement this based on your requirements
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return enabled;
    }
}