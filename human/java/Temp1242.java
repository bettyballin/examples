public class Temp1242 {
    public static void main(String[] args) {
        // Since Java does not support such annotations directly in code,
        // the code below simulates a check for a user role.
        String role = "ROLE_USER"; // This would be fetched from your security context in a real application
        
        if ("ROLE_USER".equals(role)) {
            System.out.println("Your role is \"ROLE_USER\"");
        } else {
            System.out.println("Access denied");
        }
    }
}