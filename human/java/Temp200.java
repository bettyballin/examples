public class Temp200 {
    public static void main(String[] args) {
        String username = System.getProperty("user.name"); // Simulating session username

        if (username != null && !username.isEmpty()) {
            // You can show users' profile
            System.out.println("Welcome, " + username + "!");
        } else {
            // Show login form now. You can create a login template-tag form and call it here.
            System.out.println("Please log in.");
        }
    }
}