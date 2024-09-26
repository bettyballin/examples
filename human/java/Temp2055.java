import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Component
public class Temp2055 {
    public static void main(String[] args) {
        Temp2055 temp = new Temp2055();
        InternalResourceViewResolver resolver = temp.viewResolver();
        System.out.println("View Resolver Prefix: " + resolver.getPrefix());
        System.out.println("View Resolver Suffix: " + resolver.getSuffix());
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".ftl");
        return resolver;
    }
}