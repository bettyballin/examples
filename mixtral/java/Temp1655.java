import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

public class Temp1655 {

    public static void main(String[] args) {
        // Main method content here (if needed)
    }

    public interface BookRepository extends JpaRepository<Book, Long> {

        @Override
        @PreAuthorize("#book?.owner == authentication?.name")
        <S extends Book> S save(S book);
    }

    public static class Book {
        private Long id;
        private String owner;

        // getters and setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }
    }
}