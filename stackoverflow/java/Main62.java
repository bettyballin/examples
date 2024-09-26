// Assuming 'client' is an instance of a class that has 'getOutInterceptors' and 'getInInterceptors' methods,
// and 'logger' is an instance of a Logger or similar that is expected by 'CleartextLogger' constructor.

import java.util.List;

// Define the interceptor interface if it does not exist
interface Interceptor {}

// Define the CleartextLogger if it does not exist
class CleartextLogger implements Interceptor {
    public CleartextLogger(Object logger) {
        // Implementation here
    }
}

// Mock-up class that represents the client with interceptor lists
class Client {
    private List<Interceptor> outInterceptors;
    private List<Interceptor> inInterceptors;

    public Client() {
        // Initialize interceptor lists
        outInterceptors = new ArrayList<>();
        inInterceptors = new ArrayList<>();
    }

    public List<Interceptor> getOutInterceptors() {
        return outInterceptors;
    }

    public List<Interceptor> getInInterceptors() {
        return inInterceptors;
    }
}

public class Main62 {
    public static void main(String[] args) {
        // Assuming 'logger' is previously defined and properly initialized
        Object logger = new Object(); // Placeholder for the actual logger

        CleartextLogger clearOutputLogger = new CleartextLogger(logger);
        CleartextLogger clearInputLogger = new CleartextLogger(logger);

        Client client = new Client(); // Assuming we have a client object
        client.getOutInterceptors().add(clearOutputLogger);
        client.getInInterceptors().add(clearInputLogger);
    }
}