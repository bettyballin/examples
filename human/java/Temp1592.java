import org.springframework.web.filter.DelegatingFilterProxy;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import java.util.HashMap;
import java.util.Map;

public class SpringSecurityFilterChain {

    public static void main(String[] args) throws ServletException {
        FilterConfig filterConfig = new FilterConfig() {
            private final Map<String, String> initParams = new HashMap<String, String>() {{
                put("contextAttribute", "org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");
            }};

            @Override
            public String getFilterName() {
                return "springSecurityFilterChain";
            }

            @Override
            public String getServletContext() {
                return null;
            }

            @Override
            public String getInitParameter(String name) {
                return initParams.get(name);
            }

            @Override
            public Enumeration<String> getInitParameterNames() {
                return Collections.enumeration(initParams.keySet());
            }
        };

        DelegatingFilterProxy filterProxy = new DelegatingFilterProxy();
        filterProxy.init(filterConfig);
        System.out.println("Filter Proxy Initialized with contextAttribute: " 
                + filterConfig.getInitParameter("contextAttribute"));
    }
}