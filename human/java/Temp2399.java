import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class Temp2399 {
    public static void main(String[] args) {
        UserDetails user = User.withDefaultPasswordEncoder()
                               .username("user")
                               .password("user")
                               .roles("USER")
                               .build();
        System.out.println("User created: " + user.getUsername());
    }
}