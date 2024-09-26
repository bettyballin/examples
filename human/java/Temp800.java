import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;

@Entity
class Role implements GrantedAuthority {
    @Id
    private String id;

    @ManyToMany
    private final List<Operation> allowedOperations = new ArrayList<>();

    @Override
    public String getAuthority() {
        return id;
    }

    public Collection<GrantedAuthority> getAllowedOperations() {
        return new ArrayList<>(allowedOperations);
    }
}

@Entity
class User {
    @Id
    private String id;

    @ManyToMany
    private final List<Role> roles = new ArrayList<>();

    public Collection<Role> getRoles() {
        return new ArrayList<>(roles);
    }
}

@Entity
class Operation implements GrantedAuthority {
    @Id
    private String id;

    @Override
    public String getAuthority() {
        return id;
    }
}