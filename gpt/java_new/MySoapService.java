import java.security.Principal;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService
public class MySoapService {

    @Resource
    private WebServiceContext webServiceContext;

    public void myBusinessMethod() {
        MessageContext messageContext = webServiceContext.getMessageContext();
        Principal userPrincipal = (Principal) messageContext.get(MessageContext.AUTHENTICATION_SERVICE);
        String username = userPrincipal.getName();
        // Your business logic here
    }
}