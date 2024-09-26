import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.web.filter.GenericFilterBean;

public class EncryptionFilter extends GenericFilterBean {

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        if ("EncryptedCommunication".equalsIgnoreCase(httpRequest.getHeader("Encryption"))) {
            EncryptionResponseWrapper encryptingRespWrap = new EncryptionResponseWrapper((HttpServletResponse) response);

            // Decode the request body and forward to next filter
            // Assuming decodedReqBody is obtained after some decoding logic
            String decodedReqBody = decodeRequestBody(httpRequest);

            HttpServletRequest decryptedHttpRequest = 
                new CustomDecodingRequest(httpRequest, decodedReqBody);

            filterChain.doFilter(decryptedHttpRequest, encryptingRespWrap);
        } else {
            filterChain.doFilter(request, response);
        }
    }

    private String decodeRequestBody(HttpServletRequest request) {
        // Implement your decoding logic here
        // For the sake of example, we return the input as-is
        return "decodedRequestBody";
    }
}

// Assuming EncryptionResponseWrapper and CustomDecodingRequest classes are defined elsewhere
class EncryptionResponseWrapper extends HttpServletResponseWrapper {
    public EncryptionResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    // Implement methods as needed
}

class CustomDecodingRequest extends HttpServletRequestWrapper {
    private final String decodedRequestBody;

    public CustomDecodingRequest(HttpServletRequest request, String decodedRequestBody) {
        super(request);
        this.decodedRequestBody = decodedRequestBody;
    }

    // Override methods to return decoded request body
    @Override
    public String getParameter(String name) {
        // Implement logic to return parameters from decoded request body
        return decodedRequestBody;
    }

    // Implement other methods as needed
}