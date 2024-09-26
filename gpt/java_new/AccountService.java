import org.springframework.security.access.prepost.PreAuthorize;

public class AccountService {

    @PreAuthorize("hasPermission(#id, 'Account', 'read')")
    public Account getAccountById(Long id) {
        // ... load account from the database
        return new Account(); // Replace with actual account retrieval logic
    }
}

class Account {
    // Account properties and methods
}