import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;

public class Temp72 {
    public static void main(String[] args) {
        // Assuming there's a method to obtain the request object
        // This is just a placeholder since the original request object is not provided
        javax.servlet.http.HttpServletRequest request = null; 

        // Wrapping the request
        SecurityContextHolderAwareRequestWrapper wrappedRequest = new SecurityContextHolderAwareRequestWrapper(request, "ROLE_");

        // Checking user role
        boolean hasRole = wrappedRequest.isUserInRole("USER");
        System.out.println("Has role USER: " + hasRole);
    }
}