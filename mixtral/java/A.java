import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.GenericFilterBean;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class A extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        System.out.println("filter A Before");
        // Pass control down the filter chain
        arg2.doFilter(arg0, arg1);
        System.out.println("filter A After");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }

    public static void main(String[] args) {
        // Main method for standalone testing, if needed
    }
}