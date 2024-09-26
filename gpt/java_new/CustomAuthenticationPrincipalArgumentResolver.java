import org.springframework.messaging.Message;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.method.annotation.AuthenticationPrincipalArgumentResolver;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationPrincipalArgumentResolver extends AuthenticationPrincipalArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(MyTransformedPrincipal.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, Message<?> message) {
        // Obtain the current Authentication object
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Transform it to your custom principal
        if (authentication != null && authentication.getPrincipal() instanceof MyTransformedPrincipal) {
            return (MyTransformedPrincipal) authentication.getPrincipal();
        }

        // You should add your transformation logic here
        // For now, just return null if the principal is not already an instance of MyTransformedPrincipal
        return null;
    }
}