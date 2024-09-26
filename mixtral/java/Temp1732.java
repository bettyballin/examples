import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Temp1732 {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String hashedPwd = bCrypt.encode("1"); // encode the plaintext password

        // Create UserDetails object with encoded password
        UserDetails user = User
            .builder()
            .username("1")
            .password(hashedPwd)
            .roles("USER").build();

        // For demonstration purposes, print the user details
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Authorities: " + user.getAuthorities());
    }
}