import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class Temp3593 {
    public static void main(String[] args) {
        // Sample code to execute the login method
        Temp3593 temp = new Temp3593();
        CustomUser user = new CustomUser("username", "password");
        ResponseEntity<String> response = temp.login(user);
        System.out.println(response.getBody());
    }

    public ResponseEntity<String> login(@RequestBody CustomUser customUser) {
        // Simulate login logic
        if ("username".equals(customUser.getUsername()) && "password".equals(customUser.getPassword())) {
            return ResponseEntity.ok("Login Successful");
        } else {
            return ResponseEntity.status(401).body("Login Failed");
        }
    }
}

class CustomUser {
    private String username;
    private String password;

    public CustomUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}