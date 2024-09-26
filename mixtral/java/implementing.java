import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

public class UserService {

    public UserDetails find(String username) {
        // Fetch user details from database or any other source
        // For example purpose, we are returning a hardcoded user
        return new org.springframework.security.core.userdetails.User(
                "username",
                "password",
                Collections.emptyList()
        );
    }

    // Or if you have your own custom class implementing the `UserDetails` interface:
    @Document
    class MyCustomUser implements UserDetails {
        private String username;
        private String password;
        private Collection<? extends GrantedAuthority> authorities;

        // Constructor, getters and setters

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return username;
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
    }
}