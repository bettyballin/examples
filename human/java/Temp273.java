import java.util.Collections;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

public class Temp273 {

    public static void main(String[] args) {
        // Dummy port and handler objects for demonstration purposes
        BindingProvider port = new BindingProvider() {
            @Override
            public Map<String, Object> getRequestContext() {
                return null;
            }

            @Override
            public Map<String, Object> getResponseContext() {
                return null;
            }

            @Override
            public Binding getBinding() {
                return new Binding() {
                    @Override
                    public List<Handler> getHandlerChain() {
                        return null;
                    }

                    @Override
                    public void setHandlerChain(List<Handler> handlerChain) {
                        System.out.println("Handler chain set: " + handlerChain);
                    }
                };
            }

            @Override
            public EndpointReference getEndpointReference() {
                return null;
            }

            @Override
            public <T extends EndpointReference> T getEndpointReference(Class<T> clazz) {
                return null;
            }
        };

        Handler handler = new Handler() {
            @Override
            public boolean handleMessage(javax.xml.ws.handler.MessageContext context) {
                return false;
            }

            @Override
            public boolean handleFault(javax.xml.ws.handler.MessageContext context) {
                return false;
            }

            @Override
            public void close(javax.xml.ws.handler.MessageContext context) {
            }
        };

        ((BindingProvider) port).getBinding().setHandlerChain(Collections.singletonList(handler));
    }
}