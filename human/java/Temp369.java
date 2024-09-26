public class Temp369 {
    public static void main(String[] args) {
        createRequestCallback(new RequestTransport.TransportReceiver() {
            @Override
            public void onTransportReceived() {
                // Your implementation here
                System.out.println("Transport received");
            }
        });
    }

    public static void createRequestCallback(RequestTransport.TransportReceiver receiver) {
        // Simulating a situation where the receiver is used
        receiver.onTransportReceived();
    }
}

class RequestTransport {
    interface TransportReceiver {
        void onTransportReceived();
    }
}