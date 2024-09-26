import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class Temp112 {
    public static void main(String[] args) {
        // Example usage of viewResolver method
        Temp112 temp = new Temp112();
        InternalResourceViewResolver resolver = temp.viewResolver();
        System.out.println("Prefix: " + resolver.getPrefix());
        System.out.println("Suffix: " + resolver.getSuffix());
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}