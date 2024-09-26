import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    
    // ... other methods
}

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    // Repository methods
}

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // SpringApplication.run(Application.class, args);
        // Uncomment above line to run the application
    }
}

// Assuming the existence of an Invoice entity
class Invoice {
    // Invoice entity code
}