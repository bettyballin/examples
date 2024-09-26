import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        HttpServletRequest request = // Create or obtain your HttpServletRequest instance here

        for (HandlerMapping handlerMapping : applicationContext.getBeansOfType(HandlerMapping.class).values()) {
            HandlerExecutionChain handlerExecutionChain = handlerMapping.getHandler(request);
            if (handlerExecutionChain != null) {
                // handlerExecutionChain.getHandler() is your handler for this request
                System.out.println("Handler: " + handlerExecutionChain.getHandler());
                break;
            }
        }
    }
}