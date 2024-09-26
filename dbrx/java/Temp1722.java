import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Temp1722 {

    public static void main(String[] args) {
        Temp1722 temp = new Temp1722();
        Optional<User> user = temp.findByUsername("exampleUsername");
        user.ifPresent(System.out::println);
    }

    @EntityGraph(attributePaths = {"roles"})
    public Optional<User> findByUsername(String username) {
        // This is a mock implementation for demonstration purposes
        User user = new User(username);
        user.addRole("admin");
        return Optional.of(user);
    }
}

@Entity
class User {
    private String username;
    private List<String> roles = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void addRole(String role) {
        roles.add(role);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", roles=" + roles +
                '}';
    }
}

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface EntityGraph {
    String[] attributePaths();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Entity {}