import org.springframework.security.access.prepost.PreAuthorize;

public class Temp960 {
    public static void main(String[] args) {
        Temp960 temp = new Temp960();
        System.out.println(temp.restrictedMethod());
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String restrictedMethod() {
        return "Access granted to restricted method.";
    }
}