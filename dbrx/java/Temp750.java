import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
public class Temp750 {

    public static void main(String[] args) {
        org.springframework.context.annotation.AnnotationConfigApplicationContext ctx = 
                new org.springframework.context.annotation.AnnotationConfigApplicationContext(Temp750.class);
        AccessDeniedHandler handler = ctx.getBean(AccessDeniedHandler.class);
        System.out.println("AccessDeniedHandler created: " + handler);
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    // CustomAccessDeniedHandler class definition
    static class CustomAccessDeniedHandler implements AccessDeniedHandler {
        @Override
        public void handle(javax.servlet.http.HttpServletRequest request,
                           javax.servlet.http.HttpServletResponse response,
                           org.springframework.security.access.AccessDeniedException accessDeniedException) {
            // Custom handling logic
        }
    }
}