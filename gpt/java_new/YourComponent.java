import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;

@Component
public class YourComponent {

    private final RequestMappingHandlerMapping handlerMapping;

    @Autowired
    public YourComponent(RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
    }

    public void commence(HttpServletRequest request) {
        HandlerExecutionChain handlerExecutionChain = null;
        try {
            handlerExecutionChain = handlerMapping.getHandler(request);
        } catch (Exception e) {
            // Handle the exception gracefully, perhaps log it
        }

        if (handlerExecutionChain != null) {
            Object handler = handlerExecutionChain.getHandler();
            // If the handler is a HandlerMethod, you can inspect it
            if (handler instanceof HandlerMethod) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                // Do something with handlerMethod
            }
        }
    }
}