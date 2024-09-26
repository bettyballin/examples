import javax.servlet.http.HttpServletRequest;

public class Temp193 {
    public static void main(String[] args) {
        // This is just a demonstration as `request` is typically available in a servlet context, not a main method.
        HttpServletRequest request = null; // Placeholder, in actual use this would be provided by the servlet container.
        String putYourMessageHere = "This is your error message";
        
        // Normally, this line would be within a servlet method like doGet or doPost
        // request.setAttribute("errorMessage", putYourMessageHere);
        
        // Since we can't actually run this outside of a servlet environment, we'll simulate it:
        if (request != null) {
            request.setAttribute("errorMessage", putYourMessageHere);
        } else {
            System.out.println("Simulated setting of errorMessage: " + putYourMessageHere);
        }
    }
}