import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.User; // Assuming User is in the com.example package

@Component
public class SomeConfiguration {

  @Bean
  public Function<UserDetails, User> fetchUser() {
    return (principal -> {
      String name = principal.getUsername(); // Fixed missing semicolon
      //do JPA logic
      // Assuming there's a way to fetch the User by username
      User user = new User(); // Placeholder for actual user retrieval logic
      // ... populate user with details from the database
      return user;
    });
  }
}