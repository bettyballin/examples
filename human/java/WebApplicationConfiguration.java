import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
public class WebApplicationConfiguration {
    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    public static void main(String[] args) {
        // For demonstration purposes, we can create an application context to verify the bean creation
        org.springframework.context.annotation.AnnotationConfigApplicationContext context =
                new org.springframework.context.annotation.AnnotationConfigApplicationContext(WebApplicationConfiguration.class);
        
        MultipartResolver resolver = context.getBean(MultipartResolver.class);
        System.out.println("MultipartResolver bean created: " + resolver);

        context.close();
    }
}