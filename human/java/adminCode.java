import org.springframework.security.access.annotation.Secured;

public class AdminCode {

    @Secured("ROLE_ADMIN")
    public void doAdminStuff() {
        // do stuff
        System.out.println("Admin stuff done");
    }

    public static void main(String[] args) {
        AdminCode adminCode = new AdminCode();
        adminCode.doAdminStuff();
    }
}