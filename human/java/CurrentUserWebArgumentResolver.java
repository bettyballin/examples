import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import java.security.Principal;

public class CurrentUserWebArgumentResolver implements WebArgumentResolver {
    
    @Override
    public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) {
        if (methodParameter.getParameterType().equals(User.class) &&
                methodParameter.hasParameterAnnotation(ActiveUser.class)) {
            Principal principal = webRequest.getUserPrincipal();
            if (principal instanceof Authentication) {
                return ((Authentication) principal).getPrincipal();
            }
        }
        return WebArgumentResolver.UNRESOLVED;
    }
}

@interface ActiveUser {}