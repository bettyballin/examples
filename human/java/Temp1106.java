import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp1106 {

    public static void main(String[] args) {
        // Mock params
        Params params = new Params("user@example.com", "password123");

        // Create user
        SecUser signUser = new SecUser(params.getUserEmail(), params.getUserPassword());
        signUser.save();

        // Authenticate user
        Authentication authentication = new UsernamePasswordAuthenticationToken(signUser, null, AuthorityUtils.createAuthorityList("ROLE_USER"));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        System.out.println("User authenticated: " + signUser.getUsername());
    }
}

class Params {
    private String userEmail;
    private String userPassword;

    public Params(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }
}

class SecUser {
    private String username;
    private String password;

    public SecUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void save() {
        // Mock save method
        System.out.println("User saved: " + username);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}