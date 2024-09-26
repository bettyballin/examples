import javax.security.auth.Subject;
import java.security.Principal;
import java.security.AccessControlContext;
import java.security.AccessController;

public class Temp1136 {
    public static void main(String[] args) {
        // Obtain current subject (authenticated entity)
        Subject subject = Subject.getSubject(AccessController.getContext());

        if (subject != null && !subject.getPrincipals().isEmpty()) {
            // Get the first principal which represents user's identity in CICS
            Principal cicsPrincipal = subject.getPrincipals().iterator().next();

            if ("admin".equals(cicsPrincipal.getName())) {
                System.out.println("Admin-specific functionality allowed.");
                // Allow admin-specific functionality here...
            } else {
                System.out.println("Access for other users.");
                // Deny or allow other users based on their roles/permissions.
            }
        } else {
            System.out.println("No authenticated subject found.");
        }
    }
}