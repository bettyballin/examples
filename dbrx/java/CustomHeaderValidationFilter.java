import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.regex.Pattern;

public class CustomHeaderValidationFilter implements Filter {
    private final Pattern headerNamePattern;
    private final Pattern headerValueBasePattern;
    private final Pattern HEADER_VALUE_ERROR_PATTERN;

    public CustomHeaderValidationFilter() {
        // Initialize your patterns here or use the existing ones from SecurityConfig.
        this.headerNamePattern = Pattern.compile("^[a-zA-Z0-9-]+$"); // Example pattern
        this.headerValueBasePattern = Pattern.compile("^[a-zA-Z0-9-]+$"); // Example pattern
        this.HEADER_VALUE_ERROR_PATTERN = Pattern.compile("[<>]"); // Example pattern
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        Enumeration<String> headerNames = httpRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();

            if (!headerNamePattern.matcher(headerName).matches()) {
                // Reject the request with an appropriate error message.
                httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid header name");
                return;
            }

            Enumeration<String> headersValues = httpRequest.getHeaders(headerName);
            while (headersValues.hasMoreElements()) {
                String headerValue = headersValues.nextElement();
                
                if (!headerValueBasePattern.matcher(headerValue).matches() || HEADER_VALUE_ERROR_PATTERN.matcher(headerValue).find()) {
                    // Reject the request with an appropriate error message.
                    httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid header value");
                    return;
                }
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}