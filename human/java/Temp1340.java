import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class Temp1340 {
    public static void main(String[] args) {
        // Mocking SecurityContextHolder for demonstration purposes
        org.springframework.security.core.Authentication authentication = 
            new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                "username", 
                "password", 
                new java.util.ArrayList<>()
            );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        System.out.println("Username: " + name);
    }
}