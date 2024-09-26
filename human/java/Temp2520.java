import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

public class Temp2520 {
    public static void main(String[] args) {
        // You can test the BookService implementation here if needed
    }

    @Service
    public interface BookService {

        @PreAuthorize("hasRole('ROLE_ADMIN')")
        ActionResult saveToDatabase(final BookDTO book);
    }

    // Placeholder classes for ActionResult and BookDTO
    public static class ActionResult {
        // Implementation details for ActionResult
    }

    public static class BookDTO {
        // Implementation details for BookDTO
    }
}