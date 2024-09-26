import org.springframework.data.jpa.repository.JpaRepository;

public class Temp2465 {
    public static void main(String[] args) {
        // Main method content
    }

    public interface IInvoiceRepository extends JpaRepository<Invoice, Integer> {
        // Interface methods
    }

    public class Invoice {
        private Integer id;
        private String description;

        // Getters and setters

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}