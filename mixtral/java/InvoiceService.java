import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvoiceService {

    private final IInvoiceRepository invoiceRepo;

    @Autowired
    public InvoiceService(IInvoiceRepository repo) {
        this.invoiceRepo = repo;
    }

    @Transactional
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepo.save(invoice);
    }
}

interface IInvoiceRepository {
    Invoice save(Invoice invoice);
}

class Invoice {
    // Define fields, constructors, getters, and setters here
}