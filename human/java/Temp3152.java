import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

public class Temp3152 {
    public static void main(String[] args) {
        // For demonstration, we'll just simulate an authentication principal
        UserDetails userDetails = getUserDetails();
        printUserDetails(userDetails);
    }

    @AuthenticationPrincipal
    public static UserDetails getUserDetails() {
        // Simulate a user details object
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return Collections.emptyList();
            }

            @Override
            public String getPassword() {
                return "password";
            }

            @Override
            public String getUsername() {
                return "user";
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }

    public static void printUserDetails(UserDetails userDetails) {
        if (userDetails != null) {
            System.out.println("Username: " + userDetails.getUsername());
        } else {
            System.out.println("No user details available.");
        }
    }
}