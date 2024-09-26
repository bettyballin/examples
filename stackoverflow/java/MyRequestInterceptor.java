import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

public class MyRequestInterceptor {

    public void apply(RequestTemplate template) {
        if (RequestContextHolder.getRequestAttributes() instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String authorization = request.getHeader("Authorization");
            if (StringUtils.isNotBlank(authorization)) {
                template.header("Authorization", authorization);
            }
        }
    }
    
    // Assuming RequestTemplate is a class that should be imported or defined somewhere else
    // as well as the definition of the header method used.
}