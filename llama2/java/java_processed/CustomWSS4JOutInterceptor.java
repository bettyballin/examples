import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomWSS4JOutInterceptor extends AbstractPhaseInterceptor<Message> {

    public CustomWSS4JOutInterceptor() {
        super(Phase.PREPARE_SEND);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        Map<String, Object> properties = new HashMap<>();
        properties.put(WSHandlerConstants.USER, "your_username");
        properties.put(WSHandlerConstants.PASSWORD_TYPE, WSHandlerConstants.PW_TEXT);
        properties.put(WSHandlerConstants.PW_CALLBACK_CLASS, PasswordCallbackHandler.class.getName());

        message.put(WSHandlerConstants.OUT_INTERCEPTOR_MAP, properties);
    }

    public static void main(String[] args) {
        Client client = ClientProxy.getClient(new Object()); // Replace 'new Object()' with your service interface
        CustomWSS4JOutInterceptor customInterceptor = new CustomWSS4JOutInterceptor();
        client.getOutInterceptors().add(customInterceptor);
        client.getOutInterceptors().add(new org.apache.cxf.ext.logging.LoggingOutInterceptor()); // Optional: To log outgoing messages
    }
}

class PasswordCallbackHandler implements CallbackHandler {
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof org.apache.wss4j.common.ext.WSPasswordCallback) {
                org.apache.wss4j.common.ext.WSPasswordCallback pc = (org.apache.wss4j.common.ext.WSPasswordCallback) callback;
                pc.setPassword("your_password");
            } else {
                throw new UnsupportedCallbackException(callback, "Unrecognized Callback");
            }
        }
    }
}