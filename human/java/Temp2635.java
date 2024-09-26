import org.springframework.security.core.userdetails.User;

public class Temp2635 {
    public static void main(String[] args) {
        // Example usage of User class from Spring Security
        User user = User.withUsername("user")
                .password("password")
                .roles("USER")
                .build();

        System.out.println("User: " + user.getUsername());
    }
}