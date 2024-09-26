import org.springframework.security.core.userdetails.User;

public class Temp577 {
    public static void main(String[] args) {
        // Create an instance of UserDetails using User class
        User.UserBuilder userBuilder = User.withUsername("user");
        userBuilder.password("password");
        userBuilder.roles("USER");

        org.springframework.security.core.userdetails.UserDetails userDetails = userBuilder.build();

        System.out.println("Username: " + userDetails.getUsername());
        System.out.println("Password: " + userDetails.getPassword());
        System.out.println("Authorities: " + userDetails.getAuthorities());
    }
}