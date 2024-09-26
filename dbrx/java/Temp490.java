import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;

public class Temp490 {
    public static void main(String[] args) {
        Temp490 temp = new Temp490();
        temp.bookFlight();
    }

    public void bookFlight() {
        SecurityContextHolder.setContext(new SecurityContextImpl());
        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build();
        Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);

        auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            // Process the flight reservation here.
            System.out.println("Flight booked successfully.");
        } else {
            throw new RuntimeException("User is not authenticated.");
        }
    }
}