import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.stereotype.Service;

@Service
public class Temp443 {

    public static void main(String[] args) {
        Temp443 temp = new Temp443();
        Book book = new Book();
        temp.update(book);
    }

    @PreAuthorize("hasPermission(#book, 'update')")
    public Book update(Book book) {
        // Note: In a real scenario, you would perform update logic here
        System.out.println("Book updated: " + book);
        return book;
    }
}

class Book {
    // Define your Book properties and methods here
    @Override
    public String toString() {
        return "Book";
    }
}

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig extends GlobalMethodSecurityConfiguration {
}