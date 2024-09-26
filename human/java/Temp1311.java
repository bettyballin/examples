import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import java.io.IOException;

public class Temp1311 {

    public static void main(String[] args) {
        // This is just a placeholder example to demonstrate usage.
        // In a real application, you would obtain the ServletContext from the servlet container.
        ServletContext servletContext = null; // This should be properly initialized in a real application.

        if (servletContext != null) {
            servletContext.addFilter("myFilter", MyFilter.class);
        } else {
            System.out.println("ServletContext is not initialized.");
        }
    }

    public static class MyFilter implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            // Filter initialization code
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            // Filtering code
            chain.doFilter(request, response);
        }

        @Override
        public void destroy() {
            // Filter cleanup code
        }
    }
}