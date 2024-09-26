import java.util.ArrayList;
import java.util.List;

public class Temp715 {
    public static void main(String[] args) {
        User user = new User("test", "encoded_password", getAuthorities(1));
        System.out.println(user);
    }

    public static List<String> getAuthorities(int role) {
        List<String> authorities = new ArrayList<>();
        if (role == 1) {
            authorities.add("ROLE_USER");
        } else if (role == 2) {
            authorities.add("ROLE_ADMIN");
        }
        return authorities;
    }
}

class User {
    private String username;
    private String password;
    private List<String> authorities;

    public User(String username, String password, List<String> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}