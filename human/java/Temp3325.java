import org.springframework.security.access.prepost.PreAuthorize;

public class Temp3325 {

    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public void someMethod() {
        System.out.println("Method executed with SCOPE_ADMIN authority");
    }

    public static void main(String[] args) {
        Temp3325 temp = new Temp3325();
        temp.someMethod();
    }
}