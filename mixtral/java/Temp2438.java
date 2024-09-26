import javax.servlet.Filter;

public class Temp2438 {
    public static void main(String[] args) {
        RegistrationBean registrationBean = new RegistrationBean();
        registrationBean.setFilter(new XHeaderAuthenticationFilter());
    }
}

class RegistrationBean {
    private Filter filter;

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public Filter getFilter() {
        return filter;
    }
}

class XHeaderAuthenticationFilter implements Filter {
    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws javax.servlet.ServletException {
        // Initialization code
    }

    @Override
    public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response,
            javax.servlet.FilterChain chain) throws java.io.IOException, javax.servlet.ServletException {
        // Filtering code
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code
    }
}