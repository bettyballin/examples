import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

public class Temp625 {
    public static void main(String[] args) {
        RequestCache requestCache = new HttpSessionRequestCache();
        System.out.println("RequestCache class: " + requestCache.getClass().getName());
    }
}