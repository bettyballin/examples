import org.springframework.security.core.userdetails.User;

public class Temp742 {
    public static void main(String[] args) {
        org.springframework.security.core.userdetails.UserDetails userDetails = User.withUsername("user")
                .password("password")
                .roles("USER")
                .build();

        System.out.println("Username: " + userDetails.getUsername());
        System.out.println("Password: " + userDetails.getPassword());
        System.out.println("Authorities: " + userDetails.getAuthorities());
    }
}