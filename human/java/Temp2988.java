import java.util.function.Function;

public class Temp2988 {
    public static void main(String[] args) {
        Function<UserDetails, User> fetchUser = fetchUser();
        // Use fetchUser as needed
    }

    public static Function<UserDetails, User> fetchUser() {
        return (principal -> {
            String name = principal.getUsername();
            // Perform JPA logic and return User object
            User user = new User(); // Replace with actual JPA logic
            user.setUsername(name); // Example set, replace with actual logic
            return user;
        });
    }
}

class UserDetails {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

class User {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}