import org.springframework.security.access.prepost.PreAuthorize;

public class Temp1526 {
    public static void main(String[] args) {
        // Example usage of PreAuthorize annotation
        new Temp1526().exampleMethod();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    public void exampleMethod() {
        System.out.println("PreAuthorize example method executed.");
    }
}