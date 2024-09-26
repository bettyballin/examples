import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.savedrequest.SavedRequest;

public class Temp2661 {
    private static final String ORIG_SAVED_REQUEST_URL = "ORIG_SAVED_REQUEST_URL";
    private static final String ORIG_SAVED_REQUEST = "ORIG_SAVED_REQUEST";
    private static final String SPRING_SECURITY_SAVED_REQUEST = "SPRING_SECURITY_SAVED_REQUEST";
    private static final Logger logger = LoggerFactory.getLogger(Temp2661.class);

    public static void main(String[] args) {
        // Dummy request for demonstration purposes
        HttpServletRequest request = new DummyRequest();

        SavedRequest savedRequest = null;
        if (request.getSession().getAttribute(ORIG_SAVED_REQUEST_URL) != null) {
            String saveURL = request.getSession().getAttribute(ORIG_SAVED_REQUEST_URL).toString();
            savedRequest = (SavedRequest) request.getSession().getAttribute(ORIG_SAVED_REQUEST);
            request.getSession().setAttribute(ORIG_SAVED_REQUEST_URL, saveURL);
            request.getSession().setAttribute(ORIG_SAVED_REQUEST, savedRequest);
            request.getSession().setAttribute(SPRING_SECURITY_SAVED_REQUEST, savedRequest);
            logger.debug("Session Variable ORIG-SAVED-REQUEST={}", savedRequest.getRedirectUrl());
        }
    }

    // Dummy classes to simulate HttpServletRequest and HttpSession
    private static class DummyRequest implements HttpServletRequest {
        private final HttpSession session = new DummySession();

        @Override
        public HttpSession getSession() {
            return session;
        }

        // Other methods are omitted for brevity
        // Implement only the methods you need for testing

        @Override
        public HttpSession getSession(boolean create) {
            return session;
        }

        // Implement other methods as required
    }

    private static class DummySession implements HttpSession {
        private final Map<String, Object> attributes = new HashMap<>();

        @Override
        public Object getAttribute(String name) {
            return attributes.get(name);
        }

        @Override
        public void setAttribute(String name, Object value) {
            attributes.put(name, value);
        }

        // Other methods are omitted for brevity
        // Implement only the methods you need for testing

        // Implement other methods as required
    }
}