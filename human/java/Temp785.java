import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/spring_config.xml")
public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("your.package.name"); // replace with your actual package name
        context.refresh();

        // Assuming you have a bean called 'yourBean' defined in spring_config.xml
        Object yourBean = context.getBean("yourBean");
        System.out.println(yourBean);

        context.close();
    }
}