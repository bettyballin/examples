import java.util.Optional;

public class Temp3394 {

    public static void main(String[] args) {
        Optional<User> user = findByCredentials_Username("exampleUsername");
        user.ifPresent(value -> System.out.println("User found: " + value.getUsername()));
    }

    public static Optional<User> findByCredentials_Username(String username) {
        // Assuming a static list of users for demonstration purposes
        User[] users = {
                new User("exampleUsername", "password123"),
                new User("anotherUser", "password456")
        };

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
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