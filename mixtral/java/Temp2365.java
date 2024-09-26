import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;

@Configuration
public class Temp2365 {
    public static void main(String[] args) {
        // Spring Boot application entry point would go here.
        // This class is a configuration class, not intended to be run directly.
    }

    @Bean
    public ServletContextInitializer servletContextInitialize(@Value("${secureCookie}") boolean secureCoookie) {
        return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                SessionCookieConfig sessionCookieConfig = servletContext.getSessionCookieConfig();

                // Set the name of your custom cookie
                sessionCookieConfig.setName("mujiinaSpSeessionId");

                // Enable secure cookies if required
                sessionCookieConfig.setSecure(secureCoookie);

                // Prevent JavaScript access to cookies
                sessionCookieConfig.setHttpOnly(true);
            }
        };
    }
}