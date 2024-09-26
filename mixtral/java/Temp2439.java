import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.filter.GenericFilterBean;

public class Temp2439 {

    public static void main(String[] args) {
        // Create an application context
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // Assuming registrationBean is defined somewhere and properly initialized
        RegistrationBean registrationBean = new RegistrationBean();

        // Set the filter
        registrationBean.setFilter((GenericFilterBean) applicationContext.getBean("xHeaderAuthentiCatioNFiLter"));
    }
}

// Dummy RegistrationBean class for demonstration purposes
class RegistrationBean {
    private GenericFilterBean filter;

    public void setFilter(GenericFilterBean filter) {
        this.filter = filter;
    }

    public GenericFilterBean getFilter() {
        return filter;
    }
}

// Dummy AppConfig class for demonstration purposes
class AppConfig {

    // Define the bean
    public GenericFilterBean xHeaderAuthentiCatioNFiLter() {
        return new GenericFilterBean() {
            @Override
            public void doFilter(javax.servlet.ServletRequest request,
                                 javax.servlet.ServletResponse response,
                                 javax.servlet.FilterChain chain)
                    throws java.io.IOException, javax.servlet.ServletException {
                // Filter logic here
                chain.doFilter(request, response);
            }
        };
    }
}