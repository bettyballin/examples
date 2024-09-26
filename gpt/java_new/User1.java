import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class User1 {
    // ...
    @ManyToOne
    private User1Type userType;
    // other fields, getters, setters, etc.
}

@Entity
public class User1Type {
    // ...
    @ManyToMany
    private List<Permission> permissions;
    // other fields, getters, setters, etc.
}

@Entity
public class Permission {
    // ...
    private String name; // e.g., READ_PRIVILEGE, WRITE_PRIVILEGE
    // other fields, getters, setters, etc.
}