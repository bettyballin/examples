import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ClientExample {

    public static void main(String[] args) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(TheServiceInterface.class);
        factory.setAddress("http://fqdn/service/Endpoint?wsdl");

        // Setup security interceptor
        Map<String, Object> outProps = new HashMap<>();
        outProps.put("action", "Timestamp UsernameToken");
        outProps.put("user", "test.user");
        outProps.put("passwordType", "PasswordNone");

        WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
        factory.getOutInterceptors().add(wssOut);

        TheServiceInterface client = (TheServiceInterface) factory.create();
        // Now you can use the client to call service methods
    }

    public static class ClientPasswordCallback implements CallbackHandler {
        @Override
        public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
            for (Callback callback : callbacks) {
                if (callback instanceof WSPasswordCallback) {
                    WSPasswordCallback pc = (WSPasswordCallback) callback;
                    if ("test.user".equals(pc.getIdentifier())) {
                        pc.setPassword("password"); // Set appropriate password if needed
                    }
                }
            }
        }
    }
}

interface TheServiceInterface {
    // Define the methods corresponding to the web service
}