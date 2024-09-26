public class Temp1438 {
    public static void main(String[] args) {
        System.out.println("Executing Temp1438...");

        // Assuming the intent is to demonstrate a security configuration snippet.
        String[] antMatchers = {"/dashboard", "/profile"};
        String[] roles = {"USER", "ADMIN"};

        boolean hasAccess = hasAnyRole(antMatchers, roles);
        System.out.println("Access Granted: " + hasAccess);
    }

    public static boolean hasAnyRole(String[] paths, String[] roles) {
        // Dummy implementation for demonstration purposes
        // In a real-world scenario, this would check user roles against paths
        for (String path : paths) {
            System.out.println("Checking access for path: " + path);
            for (String role : roles) {
                System.out.println("Allowed role: " + role);
            }
        }
        return true; // Assuming access is granted for demonstration
    }
}