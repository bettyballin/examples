import java.util.ArrayList;
import java.util.List;

public class Temp1478 {

    public static void main(String[] args) {
        // Assuming user is defined somewhere
        User user = new User("ROLE_USER");

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        System.out.println(authorities);
    }
}

class SimpleGrantedAuthority {
    private String role;

    public SimpleGrantedAuthority(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SimpleGrantedAuthority{" +
                "role='" + role + '\'' +
                '}';
    }
}

class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}