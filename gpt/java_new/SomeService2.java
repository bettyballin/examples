import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser_Id(Long userId);
}

// Assuming User and AppRole classes are defined somewhere and userRoleRepository is injected
public class SomeService2 {
    private final UserRoleRepository userRoleRepository;

    public SomeService2(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public List<AppRole> findRolesByUser(User user) {
        List<UserRole> userRoles = userRoleRepository.findByAppUser_Id(user.getId());
        return userRoles.stream().map(UserRole::getRole).collect(Collectors.toList());
    }
}