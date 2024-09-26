import org.springframework.security.access.prepost.PreAuthorize;

public class Temp734 {

    public static void main(String[] args) {
        Temp734 temp = new Temp734();
        // Example usage
        temp.exampleMethod(new Object());
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN') and hasPermission(#request, 'WRITE_PRIVILEGE')")
    public void exampleMethod(Object request) {
        System.out.println("Method executed with request: " + request);
    }
}