import org.springframework.stereotype.Service;
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;

@Service
public class FooService {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Foo> findAll() {
        // Method implementation goes here
        return null;
    }
    // Rest of the class implementation
}