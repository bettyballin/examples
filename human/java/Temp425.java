import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class Temp425 {
    public static void main(String[] args) {
        // Assuming account object is available and has getAccountNumber method
        Account account = new Account("12345"); // Example account initialization

        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isPermitted("account:withdraw:" + account.getAccountNumber())) {
            // handle withdraw
            System.out.println("Withdraw permitted for account: " + account.getAccountNumber());
        } else {
            System.out.println("Withdraw not permitted for account: " + account.getAccountNumber());
        }
    }
}

class Account {
    private String accountNumber;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}