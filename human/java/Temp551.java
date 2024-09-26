import java.security.AccessController;
import javax.security.auth.Subject;

public class Temp551 {
    public static void main(String[] args) {
        Subject subject = Subject.getSubject(AccessController.getContext());
        System.out.println(subject);
    }
}