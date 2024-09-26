import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;

public class Temp92 {
    public static void main(String[] args) {
        Temp92 temp = new Temp92();
        DefaultAnnotationHandlerMapping mapping = temp.defaultAnnotationHandlerMapping();
        System.out.println("Mapping created: " + mapping);
    }

    @Bean
    public DefaultAnnotationHandlerMapping defaultAnnotationHandlerMapping() {
        DefaultAnnotationHandlerMapping mapping = new DefaultAnnotationHandlerMapping();
        mapping.setDetectHandlers(false);
        return mapping;
    }
}