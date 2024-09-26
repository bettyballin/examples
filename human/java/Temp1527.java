import org.springframework.security.access.prepost.PreAuthorize;

public class Temp1527 {
    @PreAuthorize("hasRole('ROLE_USER')")
    public void securedMethod() {
        System.out.println("This method is secured and requires ROLE_USER.");
    }

    public static void main(String[] args) {
        Temp1527 temp = new Temp1527();
        temp.securedMethod();
    }
}