import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.savedrequest.NullRequestCache;

public class Temp1159 {
    public static void main(String[] args) {
        // This is a placeholder for the main method.
        // Add code here to execute if necessary.
    }

    public HttpSecurity configureHttp(HttpSecurity http, AccessDeniedHandler intranetSecurityAccessDeniedHandler) throws Exception {
        http.requestCache().requestCache(new NullRequestCache());
        return http;
    }
}