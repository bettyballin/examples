import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Temp156 {

    public static void main(String[] args) {

        List<String> permissions = Arrays.asList("list_users_permission");
        UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(
                        "scheduler", // username can be anything you want
                        null,       // password not needed here
                        permissions.stream()
                                .map(SimpleGrantedAuthority::new)
                                .collect(Collectors.toList())
                );

        SecurityContextHolder.setContext(SecurityContextHolder.createEmptyContext());
        SecurityContextHolder.getContext().setAuthentication(auth);

        // Now call your method:
        List<User> users = getAllUsers();

    }

    // Dummy method to make the code compile
    public static List<User> getAllUsers() {
        return Arrays.asList(new User("User1"), new User("User2"));
    }

    // Dummy User class to make the code compile
    static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}