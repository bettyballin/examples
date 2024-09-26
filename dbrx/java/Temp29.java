import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.frontend.ClientProxy;

public class Temp29 {
    public static void main(String[] args) {
        String url = "http://example.com/service?wsdl"; // replace with actual URL

        MessageHandlerService service = new MessageHandlerService(url);
        Client client = ClientProxy.getClient(service.getService());
    }
}

class MessageHandlerService {
    private String url;
    private Client client;

    public MessageHandlerService(String url) {
        this.url = url;
        initializeService();
    }

    private void initializeService() {
        // Initialize the service
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        client = dcf.createClient(url);
    }

    public Client getService() {
        return client;
    }
}