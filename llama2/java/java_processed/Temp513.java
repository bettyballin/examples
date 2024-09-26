public class Temp513 {
    public static void main(String[] args) {
        String redirectTo = "http://example.com"; // Example redirect URL

        // Validate the redirectTo value before sending it to the client
        if (!redirectTo.startsWith("http://") && !redirectTo.startsWith("https://")) {
            // Handle invalid redirects
            System.out.println("Invalid redirect URL");
        } else {
            System.out.println("Redirecting to: " + redirectTo);
        }
    }
}