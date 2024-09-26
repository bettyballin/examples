import org.springframework.stereotype.Service;
import org.springframework.security.access.prepost.PreAuthorize;

@Service
public interface BookService1 {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ActionResult saveToDatabase(final BookDTO book);
}