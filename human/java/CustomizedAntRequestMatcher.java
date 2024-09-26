import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class CustomizedAntRequestMatcher implements RequestMatcher {

    @Override
    public boolean matches(HttpServletRequest request) {
        String url = "/saml/SSO/**"; //change this line to get your dynamic configuration
        AntPathRequestMatcher antPathRequestMatcher = new AntPathRequestMatcher(url);
        return antPathRequestMatcher.matches(request);
    }

    public static void main(String[] args) {
        // Example usage
        HttpServletRequest request = new MockHttpServletRequest("GET", "/saml/SSO/test");
        CustomizedAntRequestMatcher matcher = new CustomizedAntRequestMatcher();
        System.out.println(matcher.matches(request)); // Should print true or false based on the URL
    }
}

class MockHttpServletRequest implements HttpServletRequest {
    private final String method;
    private final String requestURI;

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

    // Implement other methods from HttpServletRequest as needed
    // For simplicity, we are only using getMethod() and getRequestURI()
}