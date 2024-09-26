import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.savedrequest.SavedRequest;

public class Temp2662 {
    private static final Logger logger = LoggerFactory.getLogger(Temp2662.class);
    private static final String SPRING_SECURITY_SAVED_REQUEST = "SPRING_SECURITY_SAVED_REQUEST";
    private static final String ORIG_SAVED_REQUEST_URL = "ORIG_SAVED_REQUEST_URL";
    private static final String ORIG_SAVED_REQUEST = "ORIG_SAVED_REQUEST";

    public static void main(String[] args) {
        // To make this code executable, we need to create a mock request and session.
        // In real scenarios, these would be provided by the servlet container.
        HttpServletRequest request = new MockHttpServletRequest();
        
        if ((request != null) && (request.getSession() != null) &&
                (request.getSession().getAttribute(SPRING_SECURITY_SAVED_REQUEST) != null)) {
            SavedRequest savedRequest = (SavedRequest) request.getSession().getAttribute(SPRING_SECURITY_SAVED_REQUEST);
            request.getSession().setAttribute(ORIG_SAVED_REQUEST_URL, savedRequest.getRedirectUrl());
            request.getSession().setAttribute(ORIG_SAVED_REQUEST, savedRequest);
            logger.debug("Session Variable ORIG-SAVED-REQUEST={}", savedRequest.getRedirectUrl());
        }
    }
}

// Mock classes to simulate HttpServletRequest and HttpSession
class MockHttpServletRequest implements HttpServletRequest {
    private final HttpSession session;

    public MockHttpServletRequest() {
        this.session = new MockHttpSession();
    }

    @Override
    public HttpSession getSession() {
        return this.session;
    }

    // Implement other methods of HttpServletRequest as needed
    // For simplicity, only the relevant methods are implemented here

    // ... other methods ...

    @Override
    public HttpSession getSession(boolean create) {
        return this.session;
    }

    // Implement other methods...
}

class MockHttpSession implements HttpSession {
    private final Map<String, Object> attributes = new HashMap<>();

    @Override
    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    @Override
    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    // Implement other methods of HttpSession as needed
    // For simplicity, only the relevant methods are implemented here

    // ... other methods ...

    @Override
    public Enumeration<String> getAttributeNames() {
        return Collections.enumeration(attributes.keySet());
    }

    // Implement other methods...
}