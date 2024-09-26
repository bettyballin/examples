import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.bind.support.WebDataBinderFactory;

import javax.annotation.Resource;

// Assuming necessary imports and custom annotations (CurrentUser, UserPrincipal, AuthenticationFacade) are defined elsewhere

@Component
public class CurrentUserArgumentResolver implements HandlerMethodArgumentResolver {

    @Resource
    private AuthenticationFacade authenticationFacade;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(CurrentUser.class) != null &&
                UserPrincipal.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory)
            throws Exception {

        Authentication authentication = authenticationFacade.getAuthentication();

        if (authentication == null) {
            throw new IllegalStateException("Current user not found");
        }

        return ((UserPrincipal) authentication.getPrincipal());
    }
}