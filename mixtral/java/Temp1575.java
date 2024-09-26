import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temp1575 {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @DeleteMapping("/bank-accounts/{id}")
    public ResponseEntity<String> deleteBankAccount(@PathVariable Long id){
        BankAccount bankAccount = bankAccountRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No such account exists"));

        if(!SecurityUtils.getCurrentUserLogin().equalsIgnoreCase(bankAccount.getOwner())){
            return ResponseEntity.badRequest()
                .body("You are not authorized to delete this bank account");
        }

        // Proceed with deletion
        bankAccountRepository.delete(bankAccount);
        return ResponseEntity.ok("Bank account deleted successfully");
    }

    public static void main(String[] args) {
        // Application entry point
    }
}

// Assuming the existence of these classes/interfaces for compilation
class BankAccountRepository {
    public java.util.Optional<BankAccount> findById(Long id) {
        return java.util.Optional.empty(); // Dummy implementation
    }

    public void delete(BankAccount bankAccount) {
        // Dummy implementation
    }
}

class BankAccount {
    public String getOwner() {
        return "owner"; // Dummy implementation
    }
}

class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}

class SecurityUtils {
    public static String getCurrentUserLogin() {
        return "user"; // Dummy implementation
    }
}