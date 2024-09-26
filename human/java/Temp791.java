public class Temp791 {
    public static void main(String[] args) {
        String somePage = "/somePage.html";
        Object someTemporaryFlag = getSessionAttribute("someTemporaryFlag");

        if (someTemporaryFlag != null) {
            System.out.println("Access granted to " + somePage);
        } else {
            System.out.println("Access denied to " + somePage);
        }
    }

    // Mock method to simulate session attribute retrieval
    private static Object getSessionAttribute(String attributeName) {
        // Replace with actual session retrieval logic
        // For example purposes, let's return a non-null value
        if ("someTemporaryFlag".equals(attributeName)) {
            return new Object(); // Simulating a set attribute
        }
        return null; // Simulating no attribute set
    }
}