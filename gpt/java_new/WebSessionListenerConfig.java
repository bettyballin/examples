import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.ServletListenerRegistrationBean;

import javax.servlet.http.HttpSessionListener;

@Configuration
public class WebSessionListenerConfig {

    @Bean
    public ServletListenerRegistrationBean<HttpSessionListener> httpSessionListener() {
        return new ServletListenerRegistrationBean<>(new InitHttpSessionListener());
    }

    private static class InitHttpSessionListener implements HttpSessionListener {
        // Implement the required methods from HttpSessionListener
    }
}