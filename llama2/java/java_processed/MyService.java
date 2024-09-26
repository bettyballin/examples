import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MyService {
    @PreAuthorize("hasPermission('read_data')")
    public List<Data> getAllData() {
        // Implementation
        return List.of(); // Placeholder implementation
    }

    // Dummy Data class for demonstration
    public static class Data {
        // Fields and methods for Data class
    }
}