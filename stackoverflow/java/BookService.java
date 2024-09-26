import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void saveToDatabase(final BookDTO book);
}