public class Temp2627 {
    public static void main(String[] args) {
        // Simulating a security check call with placeholder values
        String authenticationPrincipal = "userPrincipal";
        String username = "myPageUser";
        boolean isAuthorized = isMyPage(authenticationPrincipal, username);
        
        System.out.println("Is authorized: " + isAuthorized);
    }

    // Placeholder method to simulate security service check
    public static boolean isMyPage(String principal, String username) {
        return principal.equals(username);
    }
}