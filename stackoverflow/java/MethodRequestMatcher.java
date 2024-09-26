import javax.servlet.http.HttpServletRequest;

public class MethodRequestMatcher implements RequestMatcher {
    private RequestMethod method;

    public MethodRequestMatcher(RequestMethod method) {
        this.method = method;
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        return method != null && method.name().equalsIgnoreCase(request.getMethod());
    }
}