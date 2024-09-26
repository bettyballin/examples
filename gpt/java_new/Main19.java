import java.security.AccessController;
import java.security.PrivilegedAction;

public class Main19 {
    public static void main(String[] args) {
        AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
            // put your file operations here
            return null;
        });
    }
}