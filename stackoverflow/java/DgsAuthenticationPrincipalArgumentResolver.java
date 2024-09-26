import com.netflix.graphql.dgs.context.DgsContext;
import com.netflix.graphql.dgs.internal.DgsDataFetchingEnvironment;
import org.springframework.core.MethodParameter;
import org.springframework.security.web.method.annotation.AuthenticationPrincipalArgumentResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

@Component
public class DgsAuthenticationPrincipalArgumentResolver implements ArgumentResolver {
    private final AuthenticationPrincipalArgumentResolver delegate = new AuthenticationPrincipalArgumentResolver();

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return delegate.supportsParameter(parameter);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, DataFetchingEnvironment dfe) {
        DgsDataFetchingEnvironment dgsEnvironment = new DgsDataFetchingEnvironment(dfe);
        DgsContext dgsContext = dgsEnvironment.getDgsContext();
        NativeWebRequest webRequest = ((DgsWebMvcRequestData) dgsContext.getRequestData()).getWebRequest();
        return delegate.resolveArgument(parameter, null, webRequest, null);
    }
}