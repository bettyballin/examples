import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.data.repository.CrudRepository;

public class Temp1989 {
    public static void main(String[] args) {
        System.out.println("Application started");
    }

    @PreAuthorize("hasAnyRole('ROLE_USER_MANAGER', 'ROLE_INTERNAL')")
    public interface UserRepository extends CrudRepository<User, String>, UserSignUpExtension {
    }

    interface UserSignUpExtension {
        // Define methods for the extension
    }

    class User {
        // Define the User class fields and methods
    }
}