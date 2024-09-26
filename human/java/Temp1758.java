import org.springframework.security.access.prepost.PreAuthorize;

public class Temp1758 {

    public static void main(String[] args) {
        Temp1758 temp = new Temp1758();
        temp.doAdminStuff();
    }

    @PreAuthorize("authentication.name == 'admin'")
    public void doAdminStuff() {
        System.out.println("Admin stuff done!");
    }
}