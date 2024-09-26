// Assuming context is a valid ApplicationContext instance
// The following code refactors the comments and executes the methods on the context object.

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext();
        ((AnnotationConfigApplicationContext) context).register(IocConfig.class);
        ((AnnotationConfigApplicationContext) context).refresh();
    }
}