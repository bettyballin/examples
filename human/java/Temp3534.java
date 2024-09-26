import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Temp3534 {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public static void main(String[] args) {
        // Spring Application Context setup is required to run the @Autowired part
        // For simplicity, we will use a SpringApplication to initialize the context
        org.springframework.boot.SpringApplication.run(Temp3534.class, args);
    }
}

interface InvoiceRepository {
    // Define methods for the repository
}