import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class Temp2713 {
    public static void main(String[] args) {
        Temp2713 temp = new Temp2713();
        ViewResolver resolver = temp.configureViewResolver();
        System.out.println("ViewResolver configured with prefix: " + ((InternalResourceViewResolver)resolver).getPrefix());
        System.out.println("ViewResolver configured with suffix: " + ((InternalResourceViewResolver)resolver).getSuffix());
    }

    @Bean
    public ViewResolver configureViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}