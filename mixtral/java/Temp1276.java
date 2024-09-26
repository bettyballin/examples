import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Temp1276 {
    public static void main(String[] args) {
        // Replace with your service class and endpoint URL
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(YourServiceClass.class);
        factory.setAddress("http://your_service_endpoint");

        YourServiceClass clientProxy = (YourServiceClass) factory.create();
        Client client = ClientProxy.getClient(clientProxy);

        PasswordProtection pp = new PasswordProtection("your_password".toCharArray());
        Map<String, Object> outProps = new HashMap<>();
        outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.SIGNATURE);
        outProps.put(WSHandlerConstants.USER, "your_username");
        outProps.put(WSHandlerConstants.PW_CALLBACK_REF, pp);

        client.getOutInterceptors().add(new WSS4JOutInterceptor(outProps));

        // Call your service methods on clientProxy here
    }
}

class PasswordProtection implements CallbackHandler {
    private final char[] password;

    public PasswordProtection(char[] password) {
        this.password = password;
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof WSPasswordCallback) {
                WSPasswordCallback pc = (WSPasswordCallback) callback;
                pc.setPassword(new String(password));
            } else {
                throw new UnsupportedCallbackException(callback, "Unrecognized Callback");
            }
        }
    }
}

// Replace with your actual service class interface
interface YourServiceClass {
    // Define your service methods here
}