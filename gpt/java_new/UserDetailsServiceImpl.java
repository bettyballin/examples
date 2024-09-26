import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Assuming we have a method getUserByUsername that retrieves user information
        // from a database or another source.
        UserEntity userEntity = getUserByUsername(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(userEntity.getAuthorities())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

    private UserEntity getUserByUsername(String username) {
        // Method to retrieve user from a data source.
        return null; // Placeholder for actual implementation.
    }

    // Assuming we have a UserEntity class that represents the user data
    private static class UserEntity {
        private String username;
        private String password;
        private List<GrantedAuthority> authorities;

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public List<GrantedAuthority> getAuthorities() {
            return authorities;
        }
    }
}