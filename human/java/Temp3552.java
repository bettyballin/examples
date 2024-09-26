import com.netflix.graphql.dgs.internal.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.webmvc.components.DgsWebMvcRequestData;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.method.annotation.AuthenticationPrincipalArgumentResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

@Component
class DgsAuthenticationPrincipalArgumentResolver implements HandlerMethodArgumentResolver {
    private final AuthenticationPrincipalArgumentResolver delegate = new AuthenticationPrincipalArgumentResolver();

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return delegate.supportsParameter(parameter);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        DgsWebMvcRequestData requestData = (DgsWebMvcRequestData) ((DgsDataFetchingEnvironment) webRequest.getAttribute(DgsWebMvcRequestData.class.getName(), NativeWebRequest.SCOPE_REQUEST)).getDgsContext().requestData;
        NativeWebRequest nativeWebRequest = (NativeWebRequest) requestData.webRequest;
        return delegate.resolveArgument(parameter, mavContainer, nativeWebRequest, binderFactory);
    }
}