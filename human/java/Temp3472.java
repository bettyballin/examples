import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class Temp3472 {
    public static void main(String[] args) {
        // The main method can be used to test the resolveArgument method if needed.
    }

    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory)
            throws Exception {

        final var auth = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        final var token = auth.getToken();
        if (token.hasClaim("uid")) {
            return token.getClaimAsString("uid");
        } else {
            return null;
        }
    }
}