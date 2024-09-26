import org.springframework.security.web.DefaultRedirectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QueryStringPropagateRedirectStrategy extends DefaultRedirectStrategy {

    @Override
    public void sendRedirect(HttpServletRequest request,
                             HttpServletResponse response, String url) throws IOException {
        String urlWithOriginalQueryString = url + "?" + request.getQueryString();
        super.sendRedirect(request, response, urlWithOriginalQueryString);
    }

    // Main method to make the class executable for testing purposes
    public static void main(String[] args) {
        // Mock request and response for demonstration purposes
        HttpServletRequest request = new MockHttpServletRequest("GET", "/test");
        HttpServletResponse response = new MockHttpServletResponse();

        QueryStringPropagateRedirectStrategy strategy = new QueryStringPropagateRedirectStrategy();
        try {
            ((MockHttpServletRequest) request).setQueryString("param1=value1&param2=value2");
            strategy.sendRedirect(request, response, "http://example.com");
            System.out.println("Redirect executed to: " + ((MockHttpServletResponse) response).getRedirectedUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Mock classes for HttpServletRequest and HttpServletResponse
class MockHttpServletRequest implements HttpServletRequest {
    private String method;
    private String requestURI;
    private String queryString;

    public MockHttpServletRequest(String method, String requestURI) {
        this.method = method;
        this.requestURI = requestURI;
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public String getRequestURI() {
        return requestURI;
    }

    @Override
    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    // Implement other methods from HttpServletRequest as needed
    // For brevity, we're omitting them here
    // ...
}

class MockHttpServletResponse implements HttpServletResponse {
    private String redirectedUrl;

    @Override
    public void sendRedirect(String location) throws IOException {
        this.redirectedUrl = location;
    }

    public String getRedirectedUrl() {
        return redirectedUrl;
    }

    // Implement other methods from HttpServletResponse as needed
    // For brevity, we're omitting them here
    // ...
}