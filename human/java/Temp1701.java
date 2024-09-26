import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

class User {
    private String password;

    public User(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}

public class Temp1701 {
    public static void main(String[] args) {
        String suppliedPasswordHash = "someHash"; // This should be the hash of the supplied password
        User users = new User("correctPasswordHash"); // This should be the hash of the user's stored password

        if (!users.getPassword().equals(suppliedPasswordHash)) {
            throw new BadCredentialsException("Invalid credentials");
        }

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(users, null);
        System.out.println("Authentication successful: " + token);
    }
}