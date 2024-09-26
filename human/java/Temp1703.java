import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class Temp1703 {
    public static void main(String[] args) {
        // Assuming a user object with a getUserType method and a users object are defined
        User user = new User("admin"); // Example user object
        Object users = new Object(); // Example users object

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getUserType()));
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(users, null, authorities);

        System.out.println("Token: " + token);
    }
}

class User {
    private String userType;

    public User(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }
}