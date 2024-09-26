import org.springframework.security.access.prepost.PreAuthorize;

public class Temp118 {
    private static RoleProperties roleProperties = new RoleProperties(); // Mock RoleProperties class instance

    public static void main(String[] args) {
        Temp118 temp = new Temp118();
        temp.method();
    }

    @PreAuthorize("hasRole('" + "ADMIN" + "')") // Replace with dynamic role if needed
    public void method() {
        System.out.println("Method executed");
    }
}

// Mock RoleProperties class to simulate getting role information
class RoleProperties {
    public String getAdminRole() {
        return "ADMIN"; // Example role, replace with actual logic if necessary
    }
}