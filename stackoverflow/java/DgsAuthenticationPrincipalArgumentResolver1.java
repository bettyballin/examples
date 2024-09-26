import graphql.schema.DataFetchingEnvironment;
import com.netflix.graphql.dgs.context.DgsContext;
import com.netflix.graphql.dgs.internal.DgsWebMvcRequestData;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

@Component
public class DgsAuthenticationPrincipalArgumentResolver1 implements WebArgumentResolver {

    private final WebArgumentResolver delegate = new AuthenticationPrincipalArgumentResolver();

    @Nullable
    @Override
    public Object resolveArgument(MethodParameter parameter, NativeWebRequest request) {
        DataFetchingEnvironment dfe = (DataFetchingEnvironment) request.getAttribute(DataFetchingEnvironment.class.getName(), NativeWebRequest.SCOPE_REQUEST);
        DgsContext context = DgsContext.getCustomContext(dfe);
        return delegate.resolveArgument(parameter, request);
    }

    public boolean supportsParameter(MethodParameter parameter) {
        return delegate.supportsParameter(parameter);
    }

    private class AuthenticationPrincipalArgumentResolver extends WebArgumentResolver {
        @Nullable
        @Override
        public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) {
            // Custom logic to resolve the argument
            return null;
        }

        public boolean supportsParameter(MethodParameter parameter) {
            // Custom logic to check if the parameter is supported
            return false;
        }
    }
}