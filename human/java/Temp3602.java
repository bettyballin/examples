public class Temp3602 {
    public static void main(String[] args) {
        if (hasRole("ROLE_ADMIN")) {
            System.out.println("Admin functionality");
        }
    }

    private static boolean hasRole(String role) {
        // This is a stub for role checking; in a real application, this method should
        // check the actual roles of the authenticated user.
        // For demonstration, it always returns true.
        return true;
    }
}