import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;

import org.springframework.web.filter.DelegatingFilterProxy;

import java.util.EnumSet;

@WebListener
public class Temp761 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        ServletContext servletContext = getServletContext();
        FilterRegistration.Dynamic multipartFilter = servletContext.addFilter("multipartFilter", new DelegatingFilterProxy());
        multipartFilter.setMultipartConfig(new MultipartConfigElement("/tmp"));
        multipartFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");
    }

    public static void main(String[] args) {
        // No need to do anything here for a servlet-based application
    }
}