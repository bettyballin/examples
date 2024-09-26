import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class Temp1282 {

    public static void main(String[] args) {
        Temp1282 temp = new Temp1282();
        ViewResolverRegistry registry = new ViewResolverRegistry(null, null); // Mock or actual initialization needed
        temp.configureViewResolvers(registry);
        System.out.println("View resolvers configured.");
    }

    public void configureViewResolvers(final ViewResolverRegistry registry) {
        final InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        // Set prefix and suffix
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");

        registry.viewResolver(resolver);
    }
}