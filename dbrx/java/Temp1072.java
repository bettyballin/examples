import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.ArrayList;

public class Temp1072 {
    public static void main(String[] args) {
        // Mock authentication setup for demonstration purposes
        SecurityContextHolder.getContext().setAuthentication(
            new UsernamePasswordAuthenticationToken(
                new User("username", "password", new ArrayList<>()), 
                null, 
                new ArrayList<>()
            )
        );

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("User: " + user.getUsername());
    }
}