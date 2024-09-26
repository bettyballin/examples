import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.Filter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class JwtCookieTokenExtractorFilter implements Filter {
    private static final String ACCESS_TOKEN = "access_token";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        Cookie[] cookies = request.getCookies();

        if (cookies != null && Arrays.stream(cookies).anyMatch(cookie -> ACCESS_TOKEN.equals(cookie.getName()))) {
            Optional<Cookie> accessTokenOptional = Stream.of(cookies)
                    .filter(c -> c.getName().equalsIgnoreCase(ACCESS_TOKEN))
                    .findFirst();

            if (accessTokenOptional.isPresent()) {
                request.setAttribute("jwt", "Bearer " + accessTokenOptional.get().getValue());
            }
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}