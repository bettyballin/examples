import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.savedrequest.SavedRequest;

public class RequestProcessing {
    private static final Logger logger = LoggerFactory.getLogger(RequestProcessing.class);
    private static final String SPRING_SECURITY_SAVED_REQUEST = "SPRING_SECURITY_SAVED_REQUEST";
    private static final String ORIG_SAVED_REQUEST_URL = "ORIG_SAVED_REQUEST_URL";
    private static final String ORIG_SAVED_REQUEST = "ORIG_SAVED_REQUEST";

    public void processRequest(HttpServletRequest request) {
        SavedRequest savedRequest;
        
        if (request != null) {
            savedRequest = (SavedRequest) request.getSession().getAttribute(SPRING_SECURITY_SAVED_REQUEST);
            
            if (savedRequest != null) {
                request.getSession().setAttribute(ORIG_SAVED_REQUEST_URL, savedRequest.getRedirectUrl());
                request.getSession().setAttribute(ORIG_SAVED_REQUEST, savedRequest);
                logger.debug("Session Variable ORIG-SAVED-REQUEST={}", savedRequest.getRedirectUrl());
            }
        }
    }
}