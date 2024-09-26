import org.springframework.security.access.prepost.PreAuthorize;

public class Temp367 {

    public static void main(String[] args) {
        Temp367 temp = new Temp367();
        temp.adminMethod();
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void adminMethod() {
        System.out.println("Admin method executed");
    }
}