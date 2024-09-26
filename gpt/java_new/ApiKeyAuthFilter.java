import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApiKeyAuthFilter implements Filter {

    private static final String API_KEY_HEADER_NAME = "X-API-KEY";
    private String validApiKey = "your-api-key"; // Store and retrieve this securely!

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code can be added here if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String apiKey = httpRequest.getHeader(API_KEY_HEADER_NAME);

        if (validApiKey.equals(apiKey)) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid API Key");
        }
    }

    @Override
    public void destroy() {
        // Clean up any resources here if needed
    }
}