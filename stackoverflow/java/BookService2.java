import org.springframework.stereotype.Service;

@Service
public interface BookService2 {
    ActionResult saveToDatabase(final BookDTO book);
}