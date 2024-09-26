import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class Temp446 {
    public static void main(String[] args) {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setServletPath("/foo/secure/super/somefile.html");

        MockHttpServletResponse response = new MockHttpServletResponse();
        MockFilterChain chain = new MockFilterChain();

        // Assuming you have a filterChainProxy to use here
        // filterChainProxy.doFilter(request, response, chain);

        // Since we don't have the actual filterChainProxy, this line is commented out.
        // If you have an actual filterChainProxy, you can uncomment it and use it here.
    }
}