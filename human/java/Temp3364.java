import java.util.HashSet;
import java.util.List;
import java.util.Set;

class User {
    private Set<String> roles;

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{roles=" + roles + "}";
    }
}

interface RoleRepository {
    List<String> findAll();
}

class RoleRepositoryImpl implements RoleRepository {
    @Override
    public List<String> findAll() {
        return List.of("ROLE_USER", "ROLE_ADMIN");
    }
}

public class Temp3364 {
    public static void main(String[] args) {
        User user = new User();
        RoleRepository roleRepository = new RoleRepositoryImpl();
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        System.out.println(user);
    }
}