import javax.servlet.http.HttpServletRequest;

public class Temp2237 {
    public static void main(String[] args) {
        // This is just a placeholder to simulate an HttpServletRequest
        MockHttpServletRequest request = new MockHttpServletRequest();
        
        // Set a referer header for testing purposes
        request.addHeader("referer", "http://example.com");

        String referrer = request.getHeader("referer");
        String redirectUrl = "redirect:" + referrer;
        
        System.out.println(redirectUrl);
    }
}

// Mock implementation for HttpServletRequest for testing purposes
class MockHttpServletRequest {
    private java.util.Map<String, String> headers = new java.util.HashMap<>();

    public void addHeader(String name, String value) {
        headers.put(name, value);
    }

    public String getHeader(String name) {
        return headers.get(name);
    }
}