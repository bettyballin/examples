import org.springframework.security.core.Authentication;

// Assuming CustomUser is a class that implements UserDetails and has a getUserId method.
public class CustomUser extends org.springframework.security.core.userdetails.User {
    // ... other fields and methods ...

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    // Example method, replace with actual method implementation.
    public int getUserId() {
        // This method should return the user's ID.
        // The implementation will depend on how you store the user's ID in CustomUser.
        return 0; // Placeholder return value
    }
    
    // ... other fields and methods ...
}

// The code snippet that uses CustomUser and retrieves the userId.
public class SomeClass {
    public void someMethod() {
        Authentication authentication = /* ... get authentication ... */;
        CustomUser customUser = (CustomUser)authentication.getPrincipal();
        int userId = customUser.getUserId();
        // ... use userId ...
    }
}