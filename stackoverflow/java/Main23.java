import javax.security.auth.Subject;
import java.security.AccessController;

public class Main23 {
    public static void main(String[] args) {
        Subject subject = Subject.getSubject(AccessController.getContext());
        // Additional code using subject
    }
}