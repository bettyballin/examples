import org.springframework.security.web.DefaultRedirectStrategy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QueryStringPropagateRedirectStrategy extends DefaultRedirectStrategy {

    @Override
    public void sendRedirect(HttpServletRequest request,
                             HttpServletResponse response, String url) throws IOException {
        String query = request.getQueryString();
        String urlWithOriginalQueryString = query != null ? url + "?" + query : url;
        super.sendRedirect(request, response, urlWithOriginalQueryString);
    }
}