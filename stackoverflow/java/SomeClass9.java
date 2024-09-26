import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SomeClass9 {
    public void someMethod() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CurrentUser user;
        if (principal instanceof UserDetails) {
            user = (CurrentUser) principal;
            // Do something with user
        } else {
            // Handle the case when principal is not an instance of UserDetails
        }
    }
}

class CurrentUser extends org.springframework.security.core.userdetails.User {
    public CurrentUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    // Additional fields and methods for CurrentUser
}