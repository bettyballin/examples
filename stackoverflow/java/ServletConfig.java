import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import java.util.EnumSet;

public class ServletConfig {
    public void configureMultipartFilter(ServletContext servletContext) {
        FilterRegistration.Dynamic multipartFilter = servletContext.addFilter("multipartFilter", MultipartFilter.class);
        multipartFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");
    }
    
    // Placeholder for the MultipartFilter class definition
    public static class MultipartFilter {
        // Implementation of the filter
    }
}