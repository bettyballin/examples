class UserSession {
    public static boolean isSessionValid() {
        // Dummy implementation for demonstration
        // Replace with actual session validation logic
        return false; // change to true to simulate a valid session
    }
}

public class Temp1132 {
    public static void main(String[] args) {
        Temp1132 temp = new Temp1132();
        if (UserSession.isSessionValid()) {
            System.out.println("ready to enter");
        } else {
            System.out.println("not logged in...redirecting to login");
            temp.sendRedirect("/in_development_page");
        }
    }

    public void sendRedirect(String url) {
        // Dummy implementation for demonstration
        // Replace with actual redirect logic
        System.out.println("Redirecting to: " + url);
    }
}