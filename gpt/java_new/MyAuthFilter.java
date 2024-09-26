import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import java.util.Map;

public class MyAuthFilter extends AbstractPreAuthenticatedProcessingFilter {

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        String id = getPathVariable(request, "id");
        return id;
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return "N/A";
    }

    private String getPathVariable(HttpServletRequest request, String variableName) {
        RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
        Map<String, String> pathVariables = (Map<String, String>) attrs.getAttribute(
                "org.springframework.web.servlet.HandlerMapping.uriTemplateVariables", 
                RequestAttributes.SCOPE_REQUEST);
        return pathVariables.get(variableName);
    }
}