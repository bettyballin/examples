import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class Temp2771 {
    public static void main(String[] args) {
        RequestMatcher customRequestMatcher = new AndRequestMatcher(
            new AntPathRequestMatcher("/v1/**"), 
            new NegatedRequestMatcher(
                new AntPathRequestMatcher("/v1/users", "POST")
            ),
            new NegatedRequestMatcher(
                new AntPathRequestMatcher("/v1/users/signin", "POST")
            )
        );
    }
}