import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
public class AppConfig {

    @Bean
    public SimpleUrlAuthenticationFailureHandler authenticationFailureHandler() {
        SimpleUrlAuthenticationFailureHandler handler = new SimpleUrlAuthenticationFailureHandler();
        handler.setRedirectStrategy(queryStringPropagateRedirectStrategy());
        handler.setDefaultFailureUrl("/login");
        return handler;
    }

    @Bean
    public QueryStringPropagateRedirectStrategy queryStringPropagateRedirectStrategy() {
        return new QueryStringPropagateRedirectStrategy();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SimpleUrlAuthenticationFailureHandler handler = context.getBean(SimpleUrlAuthenticationFailureHandler.class);
        System.out.println("Bean initialized: " + handler);
    }
}

class QueryStringPropagateRedirectStrategy {
    // Implement the necessary logic for the redirect strategy
}