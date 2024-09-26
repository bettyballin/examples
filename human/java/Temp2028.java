import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class Temp2028 {

    @Autowired
    private List<HandlerMapping> handlerMappings;

    public static void main(String[] args) {
        // This main method is for demonstration and doesn't actually run the Spring context.
        // To test this, you need to run it within a Spring Boot application context.
        System.out.println("This code needs to be run within a Spring Boot application context.");
    }

    public void processRequest(HttpServletRequest request) {
        for (HandlerMapping handlerMapping : handlerMappings) {
            try {
                HandlerExecutionChain handlerExecutionChain = handlerMapping.getHandler(request);
                if (handlerExecutionChain != null) {
                    // handlerExecutionChain.getHandler() is your handler for this request
                    System.out.println("Handler found: " + handlerExecutionChain.getHandler());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}