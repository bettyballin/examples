import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class Temp752 {
    public static void main(String[] args) {
        // Example usage
        Temp752 temp = new Temp752();
        temp.method();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    public void method() {
        System.out.println("Method executed!");
    }
}