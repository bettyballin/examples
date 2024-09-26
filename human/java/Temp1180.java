public class Temp1180 {
    public static void main(String[] args) {
        // Intercept URL pattern and access logic simulation
        String urlPattern = "/login";
        boolean isAnonymous = true;  // Simulate check for anonymous user

        if ("/login".equals(urlPattern) && isAnonymous) {
            System.out.println("Access granted for anonymous user to /login");
        } else {
            System.out.println("Access denied");
        }
    }
}