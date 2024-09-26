import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CsrfTokenFetcher {

    public CsrfToken getCsrfToken() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            return (CsrfToken) attributes.getAttribute(CsrfToken.class.getName(), RequestAttributes.SCOPE_REQUEST);
        }
        return null;
    }
}