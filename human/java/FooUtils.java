import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class FooUtils {
    public static Foo generateFoo() {
        Authentication a = SecurityContextHolder
            .getContext()
            .getAuthentication();
        
        return new Foo(a.getPrincipal());
    }

    public static void main(String[] args) {
        // This part is just for demonstration purposes and will not function
        // properly without a valid Spring Security context setup.
        // SecurityContextHolder.getContext().setAuthentication(new TestingAuthenticationToken("user", "password"));
        // Foo foo = generateFoo();
        // System.out.println(foo);
    }
}

class Foo {
    private Object principal;

    public Foo(Object principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "principal=" + principal +
                '}';
    }
}