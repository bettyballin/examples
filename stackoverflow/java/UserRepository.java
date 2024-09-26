import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("hasAnyRole('ROLE_USER_MANAGER', 'ROLE_INTERNAL')")
public interface UserRepository extends CrudRepository<User, String>, UserSignUpExtension {
}