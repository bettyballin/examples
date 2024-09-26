import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.wss4j.PolicyBasedWSS4JOutInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.apache.wss4j.common.WSConstants;

import javax.xml.ws.BindingProvider;
import java.util.HashMap;
import java.util.Map;

public class Temp1036 {

    public static void main(String[] args) {

        // ...

        Map<String, Object> outProps = new HashMap<>();
        outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);

        PolicyBasedWSS4JOutInterceptor wssOut = new PolicyBasedWSS4JOutInterceptor();
        wssOut.setProperties(outProps);

        ClientPasswordCallback callback = new ClientPasswordCallback("my-username", "my-password");
        Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
        ctx.put("ws-security.callback-handler", callback);

    }

    static class ClientPasswordCallback implements javax.security.auth.callback.CallbackHandler {

        private String username;
        private String password;

        public ClientPasswordCallback(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public void handle(javax.security.auth.callback.Callback[] callbacks) throws java.io.IOException, javax.security.auth.callback.UnsupportedCallbackException {
            for (javax.security.auth.callback.Callback callback : callbacks) {
                if (callback instanceof WSPasswordCallback) {
                    WSPasswordCallback pc = (WSPasswordCallback) callback;
                    if (pc.getIdentifier().equals(username)) {
                        pc.setPassword(password);
                        return;
                    }
                }
            }
        }
    }

    // Dummy port object for the sake of example
    static Object port = new Object();
}