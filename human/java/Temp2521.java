import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

public class Temp2521 {
    public static void main(String[] args) {
        // Your main method implementation
    }

    @Service
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public interface BookService {
        ActionResult saveToDatabase(final BookDTO book);
    }

    // Dummy ActionResult class to make the example compile
    public static class ActionResult {
        // Your implementation here
    }

    // Dummy BookDTO class to make the example compile
    public static class BookDTO {
        // Your implementation here
    }
}