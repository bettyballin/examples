public class Temp408 {
    public static void main(String[] args) {
        // Java code cannot execute JavaScript directly. 
        // The following code is a simulation of the JavaScript event subscription using Java syntax.

        // Simulate the AJAX call failure handling in Java
        simulateAjaxCallFailure(302, "/login");
    }

    public static void simulateAjaxCallFailure(int status, String location) {
        if (status == 302 && location.equals("/login")) {
            System.out.println("Redirecting to /login...");
            // In an actual web application, you would use response.sendRedirect("/login");
        }
    }
}