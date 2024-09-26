import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class Temp1996 {
    public static void main(String[] args) {
        RequestMatcher requestMatcher = new AntPathRequestMatcher("/user/login");
        System.out.println("RequestMatcher created for pattern: " + requestMatcher);
    }
}