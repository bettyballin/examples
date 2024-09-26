import java.util.List;
import java.util.ArrayList;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestParam;

public class Temp596 {
    public static void main(String[] args) {
        Temp596 temp = new Temp596();
        System.out.println(temp.getAllAccounts("test@mail.com"));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    public List<String> getAllAccounts(@RequestParam(value = "mail", required = false) String mail) {
        List<String> accounts = new ArrayList<>();
        accounts.add("Account1");
        accounts.add("Account2");
        return accounts;
    }
}