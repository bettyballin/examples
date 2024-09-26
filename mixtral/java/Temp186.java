import org.springframework.security.core.annotation.AuthenticationPrincipal;
import java.security.Principal;

public class Temp186 {
    public static void main(String[] args) {
        Temp186 temp = new Temp186();
        Principal principal = new Principal() {
            @Override
            public String getName() {
                return "User";
            }
        };
        System.out.println(temp.printWelcome(principal));
    }

    public String printWelcome(@AuthenticationPrincipal Principal principal) {
        if (principal != null) {
            return "Welcome, " + principal.getName();
        }
        return "Welcome, guest!";
    }
}