import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

public UserDetails createUserWithEncodedPassword(String username, String rawPassword, PasswordEncoder encoder) {
    String encodedPassword = encoder.encode(rawPassword);
    return User.builder()
            .username(username)
            .password(encodedPassword)
            .roles("USER") // Example role, adjust as necessary
            .build();
}