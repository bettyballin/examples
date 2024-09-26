import java.util.Base64;

public class Temp1475 {
    public static void main(String[] args) {
        User user = new User("examplePassword");
        String base64Password = new String(Base64.getEncoder().encode(user.getPassword().getBytes()));
        System.out.println(base64Password);
    }
}

class User {
    private String password;

    public User(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}