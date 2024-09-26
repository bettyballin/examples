import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temp1015 {

    public static void main(String[] args) {
        // SpringApplication.run(Temp1015.class, args); // Uncomment if running in a Spring Boot context
    }

    @RequestMapping(value = "/refund/{invoiceId}", method = RequestMethod.GET)
    @PreAuthorize("@AccessPosition.toMeOpen(#invoiceId, authentication)")
    public PosTransactionRefundInfoDTO getTransactionRefund(@PathVariable("invoiceId") Long invoiceId) {
        // ... some code here
        return new PosTransactionRefundInfoDTO();
    }

    // Dummy DTO class for demonstration purposes
    public static class PosTransactionRefundInfoDTO {
        // Add fields and methods as necessary
    }
}