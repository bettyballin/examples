import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Map;

public class PageByResourceAccessDeniedHandler extends AccessDeniedHandlerImpl {

    private Map<String, String> errorPagesByPaths;
    private String defaultErrorPage;

    @Override
    public void handle(HttpServletRequest request,
                       HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException,
            ServletException {
        String errorPage = determineErrorPage(request);
        setErrorPage(errorPage);
        super.handle(request, response, accessDeniedException);
    }

    private String determineErrorPage(HttpServletRequest request) {
        AntPathMatcher apm = new AntPathMatcher();

        for (String key : errorPagesByPaths.keySet()) {
            if (apm.match(key, request.getServletPath())) {
                return errorPagesByPaths.get(key);
            }
        }
        return defaultErrorPage;
    }

    public void setErrorPagesByPaths(Map<String, String> errorPagesByPaths) {
        for (String key : errorPagesByPaths.keySet()) {
            validateErrorPage(errorPagesByPaths.get(key));
        }
        this.errorPagesByPaths = errorPagesByPaths;
    }

    public void setDefaultErrorPage(String errorPage) {
        validateErrorPage(errorPage);
        this.defaultErrorPage = errorPage;
    }

    private void validateErrorPage(String errorPage) {
        if ((errorPage != null) && !errorPage.startsWith("/")) {
            throw new IllegalArgumentException("errorPage must begin with '/'");
        }
    }
}