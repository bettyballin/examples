import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;
    private final ServerProperties serverProperties;

    @Autowired
    public CustomErrorController(ServerProperties serverProperties, ErrorAttributes errorAttributes) {
        this.serverProperties = serverProperties;
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public ResponseEntity<Map<String, Object>> customError(HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);
        HttpStatus status = getStatus(request);

        if (status == null || status.value() != 999) {
            Map<String, Object> body = getErrorAttributes(webRequest, false);
            return new ResponseEntity<>(body, status);
        }

        Map<String, Object> body = new HashMap<>();
        // Add any custom error details here
        body.put("message", "Custom error message");

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(body, headers, status);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode != null) {
            try {
                return HttpStatus.valueOf(statusCode);
            } catch (Exception ex) {
                // Ignore invalid status codes
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    private Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        return errorAttributes.getErrorAttributes(webRequest, includeStackTrace);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}