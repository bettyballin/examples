import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

public class Temp441 {
    public static void main(String[] args) {
        // Main method implementation
        Temp441 temp = new Temp441();
        Book book = new Book("Example Book");
        temp.save(book);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Book save(Book book) {
        // Save book implementation
        System.out.println("Book saved: " + book.getTitle());
        return book;
    }
}

class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

@Service
class BookService {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Book save(Book book) {
        // Save book implementation
        System.out.println("Book saved: " + book.getTitle());
        return book;
    }
}