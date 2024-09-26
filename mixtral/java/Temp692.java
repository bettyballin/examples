import org.owasp.esapi.ESAPI;

import javax.servlet.http.HttpServletRequest;

public class Temp692 {
    public static void main(String[] args) {
        // Simulate a servlet request
        HttpServletRequest request = new MockHttpServletRequest();

        // Example usage
        String input = request.getParameter("productName");
        input = ESAPI.encoder().canonicalize(input);
        // Avoid null characters
        input = input.replaceAll("\\0", "");
        request.setAttribute("cleanProductName", input);

        // Output the cleaned product name (for testing purposes)
        System.out.println(request.getAttribute("cleanProductName"));
    }
}

// MockHttpServletRequest to simulate a servlet request
class MockHttpServletRequest implements HttpServletRequest {
    // Implement only the required methods for this example
    @Override
    public String getParameter(String name) {
        // Return a sample product name with a null character for testing
        return "Example\0Product";
    }

    // The rest of the methods can be left unimplemented for this example
    // ...
}