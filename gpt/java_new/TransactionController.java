import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

public class TransactionController {

    @PreAuthorize("@accessPosition.isMyShiftOpen(authentication)")
    @RequestMapping(value = "/refund/{invoiceId}", method = RequestMethod.GET)
    public PosTransactionRefundInfoDTO getTransactionRefundInfo(@PathVariable("invoiceId") String invoiceId) {
        // Method implementation goes here
        return new PosTransactionRefundInfoDTO();
    }
}

class PosTransactionRefundInfoDTO {
    // DTO properties and methods go here
}