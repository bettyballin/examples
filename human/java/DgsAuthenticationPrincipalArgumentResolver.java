import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.core.MethodParameter;
import org.springframework.security.web.method.annotation.AuthenticationPrincipalArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingEnvironmentImpl;
import com.netflix.graphql.dgs.context.DgsContext;
import com.netflix.graphql.dgs.internal.DgsWebMvcRequestData;
import com.netflix.graphql.dgs.internal.method.ArgumentResolver;

@Component
public class DgsAuthenticationPrincipalArgumentResolver implements ArgumentResolver {

    private final AuthenticationPrincipalArgumentResolver delegate = new AuthenticationPrincipalArgumentResolver();

    @Nullable
    @Override
    public Object resolveArgument(@NotNull MethodParameter parameter, @NotNull DataFetchingEnvironment dfe) {
        DgsContext context = ((DataFetchingEnvironmentImpl) dfe).getContext();
        DgsWebMvcRequestData requestData = (DgsWebMvcRequestData) context.getRequestData();
        NativeWebRequest request = requestData == null ? null : (NativeWebRequest) requestData.getWebRequest();
        return delegate.resolveArgument(parameter, null, request, null);
    }

    @Override
    public boolean supportsParameter(@NotNull MethodParameter parameter) {
        return delegate.supportsParameter(parameter);
    }
}