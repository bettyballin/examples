import javax.security.auth.Subject;
import java.security.PrivilegedAction;
import java.util.Set;
import java.util.HashSet;

public class Temp552 {
    public static void main(String[] args) {
        // Create a Subject with appropriate Principals
        Set<java.security.Principal> principals = new HashSet<>();
        principals.add(() -> "UserPrincipal");
        Subject subject = new Subject(false, principals, new HashSet<>(), new HashSet<>());

        Subject.doAs(subject, new PrivilegedAction<Void>() {
            public Void run() {
                Foo.methodThatCaresAboutSubject();
                return null; // Need to return null because the return type is Void
            }
        });
    }
}

class Foo {
    public static void methodThatCaresAboutSubject() {
        Subject currentSubject = Subject.getSubject(java.security.AccessController.getContext());
        System.out.println("Current subject: " + currentSubject);
    }
}