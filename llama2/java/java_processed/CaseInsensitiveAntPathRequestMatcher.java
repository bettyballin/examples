import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class CaseInsensitiveAntPathRequestMatcher extends AntPathRequestMatcher {

    public CaseInsensitiveAntPathRequestMatcher(String pattern) {
        super(pattern);
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        String requestedUrl = request.getRequestURI();
        String pattern = getPattern();

        String regexPattern = pattern.replaceAll("\\*", ".*").replaceAll("\\?", ".");
        return Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE).matcher(requestedUrl).matches();
    }

    public static void main(String[] args) {
        // Test the class
        CaseInsensitiveAntPathRequestMatcher matcher = new CaseInsensitiveAntPathRequestMatcher("/test/*");
        HttpServletRequest request = null; // Replace with a real HttpServletRequest object
        System.out.println(matcher.matches(request));
    }
}