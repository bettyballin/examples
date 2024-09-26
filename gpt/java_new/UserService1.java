import org.springframework.security.access.prepost.PreAuthorize;

public class UserService1 {

    @PreAuthorize("#id == authentication.principal.id or hasAuthority('ROLE_ADMIN')")
    public UserData getUserData(Long id) {
        // fetch the user data from the database and return it
        // Dummy return for compilation
        return new UserData();
    }

    // Dummy class for compilation
    public class UserData {
        // UserData fields and methods
    }
}