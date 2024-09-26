import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class MyRequestMatcher implements RequestMatcher {

    @Override
    public boolean matches(HttpServletRequest request) {
        //Define the matching logic here....
        if (request.getHeader("xxx") != null &&
            "yyyy".equals(request.getHeader("xxx"))) {
            return true;
        }
        //blablablab
        return false;
    }
}