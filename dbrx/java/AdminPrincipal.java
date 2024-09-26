import java.security.Principal;
import javax.security.auth.Subject;
import java.security.AccessController;
import java.util.Set;

public class AdminPrincipal implements Principal {
    private String name;

    public AdminPrincipal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        // Example usage
        AdminPrincipal admin = new AdminPrincipal("adminUser");
        Subject subject = new Subject();
        subject.getPrincipals().add(admin);

        // Set the subject in the current access control context
        Subject.doAsPrivileged(subject, null, new java.security.PrivilegedAction<Void>() {
            @Override
            public Void run() {
                doSomething();
                return null;
            }
        }, null);
    }

    public static void doSomething() {
        Subject subject = Subject.getSubject(AccessController.getContext());
        if (subject != null && !subject.getPrincipals().isEmpty()) {
            Set<AdminPrincipal> principals = subject.getPrincipals(AdminPrincipal.class);
            if (!principals.isEmpty()) {
                Principal principal = principals.iterator().next();
                System.out.println("Principal Name: " + principal.getName());
                // Check the privilege level of this user
                // ...
            }
        }
    }
}