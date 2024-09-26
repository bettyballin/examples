import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class Temp2481 {

    private UserRepository userRepository = new UserRepository(); // Dummy repository for example

    public static void main(String[] args) {
        Temp2481 temp = new Temp2481();
        try {
            UserDetails userDetails = temp.loadUserByUsername("testuser");
            System.out.println("UserDetails: " + userDetails);
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BCryptPasswordEncoder encoder = passwordEncoder();
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User Name " + username + " Not Found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                encoder.encode(user.getPassword()),
                getGrantedAuthorities(user)
        );
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        // Add roles or authorities for the user
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }

    // Dummy User class
    class User {
        private String userName;
        private String password;

        public User(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }
    }

    // Dummy UserRepository class
    class UserRepository {
        public User findByUsername(String username) {
            // Dummy logic to simulate database search
            if ("testuser".equals(username)) {
                return new User("testuser", "password");
            }
            return null;
        }
    }
}