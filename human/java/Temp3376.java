import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class Temp3376 {
    public static void main(String[] args) {
        // Example user entity
        UserEntity userEntity = new UserEntity("username", "password");

        // Example roles
        List<String> roles = List.of("ROLE_USER", "ROLE_ADMIN");

        // Convert roles to GrantedAuthority list
        List<GrantedAuthority> roleList = new ArrayList<>();
        for (String role : roles) {
            roleList.add(new SimpleGrantedAuthority(role));
        }

        // Create UserDetails object
        UserDetails userDetails = new User(userEntity.getUsername(), userEntity.getPassword(), roleList);

        // Print UserDetails to verify
        System.out.println(userDetails);
    }
}

class UserEntity {
    private String username;
    private String password;

    public UserEntity(String username, String password) {
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