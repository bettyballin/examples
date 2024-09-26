public class Temp278 {
    public static void main(String[] args) {
        // Assuming you want to print the first name of the authenticated principal
        // This is a simulated example, as integration with Spring Security requires a Spring application context
        String firstName = getAuthenticatedPrincipalFirstName();
        System.out.println(firstName);
    }

    private static String getAuthenticatedPrincipalFirstName() {
        // Simulated method to get the first name of the authenticated principal
        // In a real Spring Security application, you would retrieve this from the SecurityContext
        return "John"; // Replace with actual logic to retrieve the authenticated user's first name
    }
}