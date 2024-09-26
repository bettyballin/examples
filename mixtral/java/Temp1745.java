import java.util.HashSet;
import java.util.Set;

public class Temp1745 {
    public static void main(String[] args) {
        BookRepo bookRepo = new BookRepo();
        Book bk = new Book(1, "Sample Book");
        Auth auth = new Auth("username", Set.of("ROLE_ADMIN"));
        BookingsRepo bookingsRepo = new BookingsRepo();

        if (bookRepo.exists(bk.getBook_id())) {
            bk.setUser(auth.getName());

            // Check if user has ROLE_ADMIN
            boolean isAdmin = auth.getAuthorities().contains("ROLE_ADMIN");

            // Do some calculations according to the role

            bookingsRepo.save(bk);
        }
    }
}

class BookRepo {
    // Simulate existence check
    public boolean exists(int bookId) {
        return bookId == 1; // Assume book with ID 1 exists
    }
}

class Book {
    private int book_id;
    private String title;
    private String user;

    public Book(int book_id, String title) {
        this.book_id = book_id;
        this.title = title;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }
}

class Auth {
    private String name;
    private Set<String> authorities;

    public Auth(String name, Set<String> authorities) {
        this.name = name;
        this.authorities = authorities;
    }

    public String getName() {
        return name;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }
}

class BookingsRepo {
    // Simulate save operation
    public void save(Book book) {
        System.out.println("Book saved: " + book.getTitle() + " by user " + book.getUser());
    }
}