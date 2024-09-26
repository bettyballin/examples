import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class HandlerProcessor {

    @Autowired
    private List<HandlerMapping> handlerMappings;

    public void processHandlers(HttpServletRequest request) {
        for (HandlerMapping handlerMapping : handlerMappings) {
            HandlerExecutionChain handlerExecutionChain;
            try {
                handlerExecutionChain = handlerMapping.getHandler(request);
                if (handlerExecutionChain != null) {
                    // handlerExecutionChain.getHandler() is your handler for this request
                }
            } catch (Exception e) {
                // Handle the exception as per your requirements
            }
        }
    }
}