import java.util.ArrayList;
import java.util.List;

public class Temp1305 {
    public static void main(String[] args) {
        Temp1305 temp = new Temp1305();
        List<String> accounts = temp.getAllAccounts();
        for (String account : accounts) {
            System.out.println(account);
        }
    }

    // Simulating @Secured annotation
    // @Secured("ROLE_USER")
    public List<String> getAllAccounts() {
        // Sample data
        List<String> accounts = new ArrayList<>();
        accounts.add("Account1");
        accounts.add("Account2");
        accounts.add("Account3");
        return accounts;
    }
}