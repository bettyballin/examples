import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class Temp1104 {
    public static void main(String[] args) {
        String username = "exampleUser";
        String password = "examplePassword";

        User user = new User(
            username,
            password,
            true,
            true,
            true,
            true,
            AuthorityUtils.createAuthorityList("ROLE_ADMIN")
        );

        System.out.println("User created: " + user.getUsername());
    }
}