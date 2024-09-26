import java.util.List;

public class Temp880 {
    public static void main(String[] args) {
        Temp880 temp = new Temp880();
        // Example usage
        AccountRecord record = temp.getAccountRecord(1L);
        List<AccountRecord> records = temp.getAllAccountRecords();
    }

    // Mock annotation for demonstration purposes
    @interface PreAuthorize {
        String value();
    }

    // Mock annotation for demonstration purposes
    @interface PostFilter {
        String value();
    }

    // Mock class for demonstration purposes
    class AccountRecord {
        // fields and methods
    }

    @PreAuthorize("hasPermission(#accountId, 'read')") // corrected annotation
    public AccountRecord getAccountRecord(Long accountId) {
        // Mock implementation
        return new AccountRecord();
    }

    @PostFilter("hasPermission(filterObject, 'read')")
    public List<AccountRecord> getAllAccountRecords() {
        // Mock implementation
        return List.of(new AccountRecord(), new AccountRecord());
    }
}