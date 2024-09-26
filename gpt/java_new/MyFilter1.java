import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter1 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Since the provided code snippet is incomplete, we will assume that
        // CommonVariables.LOGIN_BEAN is a constant that holds the key for the login bean in the session.
        // Also, the code to redirect or continue the filter chain is missing, so we'll add that as well.

        final String CommonVariables_LOGIN_BEAN = "loginBean"; // Placeholder for the actual constant
        String loginBean = (String) httpRequest.getSession().getAttribute(CommonVariables_LOGIN_BEAN);
        if (loginBean == null) {
            System.out.println("FILTER-----------");
            // Redirect to a login page or an error page, as appropriate.
            httpResponse.sendRedirect("/login");
        } else {
            // Continue the filter chain if the login bean exists
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Any required initialization code here
    }

    @Override
    public void destroy() {
        // Any required cleanup code here
    }
}