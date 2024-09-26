import java.util.ArrayList;
import java.util.List;

class Password {
    private String password;

    public Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class User {
    private Password password;

    public User(Password password) {
        this.password = password;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }
}

class UserDetailsService {
    public void updateUser(User user) {
        System.out.println("User password updated to: " + user.getPassword().getPassword());
    }
}

public class Temp1393 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(new Password("old_password")));
        
        UserDetailsService userDetailsService = new UserDetailsService();
        
        users.get(0).setPassword(new Password("new_password"));
        userDetailsService.updateUser(users.get(0));
    }
}