import org.apache.cxf.jaxrs.ext.ContextProvider;
import org.apache.cxf.message.Message;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationContextProvider implements ContextProvider<Authentication> {
    @Override
    public Authentication createContext(Message message) {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}