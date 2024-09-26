import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.TransformerException;
import java.util.Base64;

public class BasicAuthInterceptor implements EndpointInterceptor {

    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) {
        ServletWebRequest servletRequest = (ServletWebRequest) messageContext.getRequest();
        HttpServletRequest httpRequest = servletRequest.getRequest();
        String authorization = httpRequest.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Basic")) {
            String base64Credentials = authorization.substring("Basic".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials));
            // Further processing with credentials
            return true;
        }
        // If authorization header is not present or not Basic
        return false;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) {
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) {
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) {
        // Cleanup resources if needed
    }
}