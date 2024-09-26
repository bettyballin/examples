import org.springframework.security.access.prepost.PreAuthorize;

public class Temp43 {
    public static void main(String[] args) {
        Temp43 temp = new Temp43();
        temp.someMethod();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    public void someMethod() {
        // Simulated role check
        if (hasRole("ROLE_USER")) {
            System.out.println("Method executed.");
        } else {
            System.out.println("Access denied.");
        }
    }

    private boolean hasRole(String role) {
        // Simulated user role check
        // In a real scenario, this should check the actual user's roles.
        return "ROLE_USER".equals(role);
    }
}