import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import java.security.Principal;

public class CurrentUserWebArgumentResolver implements WebArgumentResolver {

    @Override
    public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
        if (User.class.isAssignableFrom(methodParameter.getParameterType()) && methodParameter.hasParameterAnnotation(ActiveUser.class)) {
            Principal principal = webRequest.getUserPrincipal();
            return principal instanceof Authentication ? ((Authentication) principal).getPrincipal() : null;
        } else {
            return UNRESOLVED;
        }
    }
}