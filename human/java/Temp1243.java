public class Temp1243 {
    public static void main(String[] args) {
        boolean isAuthenticated = checkAuthentication(); // Replace with actual authentication check
        String principalUsername = getPrincipalUsername(); // Replace with actual method to get username

        if (isAuthenticated) {
            System.out.println("logged in as " + principalUsername);
        } else {
            System.out.println("Not logged in");
        }
    }

    private static boolean checkAuthentication() {
        // Mock authentication check
        // Replace with actual logic to check if the user is authenticated
        return true; // or false based on the authentication status
    }

    private static String getPrincipalUsername() {
        // Mock method to get the principal username
        // Replace with actual logic to get the authenticated user's username
        return "JohnDoe";
    }
}