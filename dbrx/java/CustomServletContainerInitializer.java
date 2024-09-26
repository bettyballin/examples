import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CustomServletContainerInitializer extends SpringBootServletInitializer implements ServletContextInitializer {

    private boolean secureCookie = true; // Example value, set it accordingly

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Initialize your custom session id here after Spring Session has been initialized.
        SessionCookieConfig sessionCookieConfig = servletContext.getSessionCookieConfig();
        sessionCookieConfig.setName("mujinaSpSessionId");
        sessionCookieConfig.setSecure(this.secureCookie);
        sessionCookieConfig.setHttpOnly(true);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CustomServletContainerInitializer.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomServletContainerInitializer.class, args);
    }
}