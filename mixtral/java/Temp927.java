import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class Temp927 {
    public static void main(String[] args) {

        // Mocking the RequestContextHolder for demonstration purposes
        // In a real-world scenario, this would be managed by the Spring context
        MockServletRequestAttributes mockAttributes = new MockServletRequestAttributes();
        RequestContextHolder.setRequestAttributes(mockAttributes);

        HttpServletRequest originalRequest = mockAttributes.getRequest();
        originalRequest.setAttribute("specificValue", "exampleValue");

        SecurityContextHolderAwareRequestWrapper request = new SecurityContextHolderAwareRequestWrapper(
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());

        String specificValue = (String) request.getAttribute("specificValue");

        // Use the value as needed
        System.out.println("The specific value is: " + specificValue);
    }
}

class MockServletRequestAttributes extends ServletRequestAttributes {
    private final MockHttpServletRequest request;

    public MockServletRequestAttributes() {
        super(new MockHttpServletRequest());
        this.request = (MockHttpServletRequest) super.getRequest();
    }

    @Override
    public MockHttpServletRequest getRequest() {
        return this.request;
    }
}

class MockHttpServletRequest extends org.springframework.mock.web.MockHttpServletRequest {
    // Add any additional mock behavior here if needed
}