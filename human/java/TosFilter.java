import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
@WebFilter(urlPatterns = "/*")
public class TosFilter extends HttpFilter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        super.init(filterConfig);
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println(request.getRequestURI());

        // In realworld scenario HelloWorldController.acceptedTOS is a persisted value rather than a static variable
        if (!HelloWorldController.acceptedTOS) {
            // response.sendRedirect("/no-tos");
            request.getRequestDispatcher("error-no-tos").forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

class HelloWorldController {
    public static boolean acceptedTOS = false; // This is a placeholder
}