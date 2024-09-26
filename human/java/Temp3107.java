import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

public class Temp3107 {

    public static void main(String[] args) {
        // Example usage
        User user = new User("username", "password", true, true, true, true, null);
        System.out.println(user);
    }

    static class User {
        private String username;
        private String password;
        private boolean enabled;
        private boolean accountNonExpired;
        private boolean credentialsNonExpired;
        private boolean accountNonLocked;
        private Collection<? extends GrantedAuthority> authorities;

        public User(String username, String password, boolean enabled,
                    boolean accountNonExpired, boolean credentialsNonExpired,
                    boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
            this.username = username;
            this.password = password;
            this.enabled = enabled;
            this.accountNonExpired = accountNonExpired;
            this.credentialsNonExpired = credentialsNonExpired;
            this.accountNonLocked = accountNonLocked;
            this.authorities = authorities;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", enabled=" + enabled +
                    ", accountNonExpired=" + accountNonExpired +
                    ", credentialsNonExpired=" + credentialsNonExpired +
                    ", accountNonLocked=" + accountNonLocked +
                    ", authorities=" + authorities +
                    '}';
        }
    }
}