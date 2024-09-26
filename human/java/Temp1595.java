import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.FilterRegistration;

import org.springframework.web.filter.DelegatingFilterProxy;

public class Temp1595 {

    public static void main(String[] args) {
        // Simulate servlet context startup
        try {
            new Temp1595().onStartup(new MockServletContext());
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void onStartup(final ServletContext servletContext) throws ServletException {
        DelegatingFilterProxy filter1 = new DelegatingFilterProxy("springSecurityFilterChain");
        filter1.setServletContext(servletContext);
        filter1.setContextAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");
        DelegatingFilterProxy filter2 = new DelegatingFilterProxy("corsFilter");
        FilterRegistration.Dynamic registration1 = servletContext.addFilter("springSecurityFilterChain", filter1);
        if (registration1 != null) {
            registration1.addMappingForUrlPatterns(null, true, "/*");
        }
        FilterRegistration.Dynamic registration2 = servletContext.addFilter("corsFilter", filter2);
        if (registration2 != null) {
            registration2.addMappingForUrlPatterns(null, false, "/*");
        }
    }

    // Mock ServletContext for testing purposes
    static class MockServletContext implements ServletContext {
        // Implement necessary methods here
        // This is just a minimal implementation for demonstration purposes
        public FilterRegistration.Dynamic addFilter(String filterName, DelegatingFilterProxy filter) {
            System.out.println("Added filter: " + filterName);
            return new MockFilterRegistration();
        }

        // Other methods can be similarly mocked or left unimplemented for this example
        // ...

        static class MockFilterRegistration implements FilterRegistration.Dynamic {
            @Override
            public void addMappingForUrlPatterns(EnumSet<DispatcherType> dispatcherTypes, boolean isMatchAfter, String... urlPatterns) {
                System.out.println("Added URL mapping for: " + String.join(", ", urlPatterns));
            }

            // Implement minimal required methods
            // ...

            @Override
            public void setAsyncSupported(boolean isAsyncSupported) {}

            @Override
            public void setInitParameter(String name, String value) {}

            @Override
            public void setServletSecurity(ServletSecurityElement constraint) {}

            @Override
            public void addMappingForServletNames(EnumSet<DispatcherType> dispatcherTypes, boolean isMatchAfter, String... servletNames) {}

            @Override
            public Collection<String> getServletNameMappings() { return null; }

            @Override
            public Collection<String> getUrlPatternMappings() { return null; }

            @Override
            public String getName() { return null; }

            @Override
            public String getClassName() { return null; }

            @Override
            public boolean setInitParameters(Map<String, String> initParameters) { return false; }

            @Override
            public Map<String, String> getInitParameters() { return null; }

            @Override
            public String getInitParameter(String name) { return null; }
        }
    }
}