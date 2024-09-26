import java.util.Collection;
import java.util.stream.Stream;

interface User {
}

interface UserDetails extends User {
    Collection<? extends GrantedAuthority> getAuthorities();
}

interface GrantedAuthority {
    String getAuthority();
}

public class Temp3414 {
    public static void main(String[] args) {
        // Example usage
        User user = new UserDetailsImpl();
        System.out.println(hasAuthority(user, "ROLE_USER"));
    }

    public static boolean hasAuthority(User user, String... authorities) {
        if (user instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) user;
            for (String authority : authorities) {
                if (userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .anyMatch(a -> a.equals(authority))) {
                    return true;
                }
            }
        }
        return false;
    }
}

class UserDetailsImpl implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.of(
                () -> "ROLE_USER",
                () -> "ROLE_ADMIN"
        ).toList();
    }
}