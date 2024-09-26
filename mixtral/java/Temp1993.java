import java.util.ArrayList;
import java.util.List;

public class Temp1993 {

    public static void main(String[] args) {
        List<Interceptor<? extends Message>> outFault = new ArrayList<>();
        Interceptor<? extends Message> wss4jOut = new CustomInterceptor();
        outFault.add(wss4jOut);
        Client client = new Client();
        client.getEndpoint().getOutFaultMessageSenders().clear();
        client.getEndpoint().getOutFaultMessageSenders().addAll(outFault);
    }
}

class Message {
    // Message class implementation
}

interface Interceptor<T extends Message> {
    // Interceptor interface implementation
}

class CustomInterceptor implements Interceptor<Message> {
    // CustomInterceptor class implementation
}

class Endpoint {
    private List<Interceptor<? extends Message>> outFaultMessageSenders = new ArrayList<>();

    public List<Interceptor<? extends Message>> getOutFaultMessageSenders() {
        return outFaultMessageSenders;
    }
}

class Client {
    private Endpoint endpoint = new Endpoint();

    public Endpoint getEndpoint() {
        return endpoint;
    }
}