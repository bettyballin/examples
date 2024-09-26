import javax.servlet.http.HttpServletRequest;

public class Temp55 {
    public static void main(String[] args) {
        // This is just a placeholder, as HttpServletRequest cannot be instantiated directly
        // In a real scenario, this would be provided by the servlet container
        HttpServletRequest request = null; // Replace with actual request object in a servlet environment
        
        if (request != null) {
            String parameter = request.getParameter("param");
            System.out.println("Parameter: " + parameter);
        } else {
            System.out.println("Request object is null. This code should be run in a servlet environment.");
        }
    }
}