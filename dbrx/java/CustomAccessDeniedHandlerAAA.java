import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import java.io.IOException;
import javax.servlet.ServletException;

public class CustomAccessDeniedHandlerAAA extends AccessDeniedHandlerImpl {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // Set the error page URL for AAA resource
        setErrorPage("/access-denied-aaa");
        super.handle(request, response, accessDeniedException);
    }
}

public class CustomAccessDeniedHandlerBBB extends AccessDeniedHandlerImpl {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // Set the error page URL for BBB resource
        setErrorPage("/access-denied-bbb");
        super.handle(request, response, accessDeniedException);
    }
}

Note that the trailing slashes in the `setErrorPage` URLs were removed. This is because in Java, it's common practice to avoid trailing slashes in URLs unless explicitly needed. The Spring `setErrorPage` method likely does not expect a trailing slash, and removing it should allow the code to compile without errors.