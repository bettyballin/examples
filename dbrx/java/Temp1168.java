import java.util.ArrayList;
import java.util.List;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class Temp1168 {
    public static void main(String[] args) {
        List<AntPathRequestMatcher> requestMatchers = new ArrayList<>();
        requestMatchers.add(new AntPathRequestMatcher("/api/v1/signup/**", "GET")); // specify HTTP method
    }
}