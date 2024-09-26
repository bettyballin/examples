import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;

public class CustomMultipartResolver extends CommonsMultipartResolver {

    @Override
    public MultipartHttpServletRequest resolveMultipart(HttpServletRequest request) throws MultipartException {
        MultipartHttpServletRequest multipartRequest = super.resolveMultipart(request);
        // Extract token and do whatever you need with it, e.g., store it in a request attribute
        String token = multipartRequest.getParameter("token");
        if (token != null) {
            request.setAttribute("token", token);
        }
        return multipartRequest;
    }
}