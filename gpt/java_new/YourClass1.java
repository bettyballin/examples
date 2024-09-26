import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

// ... other imports

public class YourClass1 {
    // ... your class members and methods

    public void yourMethod() {
        // Assuming 'user' is an object of a custom User class that has 'getEmail', 'getPassword', and 'getAuthorities' methods.
        CustomUser user = ...; // Your code to get the CustomUser object.

        List<GrantedAuthority> authorities = new ArrayList<>(user.getAuthorities());
        User userDetails = new User(
            user.getEmail(),
            user.getPassword(),
            true, true, true, true,
            authorities
        );

        // ... your code that uses userDetails
    }

    // ... rest of your class
}