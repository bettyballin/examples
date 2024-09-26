import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Temp1759 {

    public static void main(String[] args) {
        Temp1759 temp = new Temp1759();
        temp.doSomeStuff();
    }

    @PreAuthorize("@myService.hasPermission(authentication.name)")
    public void doSomeStuff() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            System.out.println("Executing doSomeStuff for user: " + authentication.getName());
        } else {
            System.out.println("No authenticated user found.");
        }
    }
}