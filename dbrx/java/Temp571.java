import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        DomainUser domainUser = new DomainUser("username", "password");

        UserDetails userDetails = new User(
                domainUser.getUsername(), 
                domainUser.getPassword(), 
                true, true, true, true, 
                Collections.emptyList()
        );

        System.out.println(userDetails);
    }
}

class DomainUser {
    private String username;
    private String password;

    public DomainUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}