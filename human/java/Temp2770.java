import org.springframework.security.web.util.matcher.RequestMatcher;

public class Temp2770 {
    public static void main(String[] args) {
        RequestMatcher customRequestMatcher = request -> true; // Replace with actual matcher logic
        new JwtAuthenticationTokenFilter(customRequestMatcher);
    }
}

class JwtAuthenticationTokenFilter {
    public JwtAuthenticationTokenFilter(RequestMatcher customRequestMatcher) {
        super(customRequestMatcher);
        // Add additional initialization logic here if needed
    }
}