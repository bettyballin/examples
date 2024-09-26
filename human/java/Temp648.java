import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Temp648 {

    public static void main(String[] args) {
        Temp648 temp = new Temp648();
        Object result = temp.someMethod();
        System.out.println(result);
    }

    @PostAuthorize("hasRole('ROLE_ADMIN') or returnObject.hasDriverWithId(principal.id)")
    public Object someMethod() {
        // Example object with a method hasDriverWithId
        return new ExampleObject();
    }

    class ExampleObject {
        public boolean hasDriverWithId(Object principalId) {
            // Dummy implementation
            return true;
        }
    }
}