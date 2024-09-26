public class Temp1670 {
    public static void main(String[] args) {
        // Simulating the fetching of user's first name from authentication principal
        String firstName = getAuthenticatedUserFirstName();
        System.out.println(firstName);
    }

    // Mock method to simulate getting the authenticated user's first name
    private static String getAuthenticatedUserFirstName() {
        // In a real application, you would fetch this from the security context
        return "John"; // Example name
    }
}