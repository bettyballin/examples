import java.util.function.Consumer;

public class Temp1108 {
    public static void main(String[] args) {
        String mycustomidentifier = "exampleIdentifier";
        Consumer<String> onmessage = message -> System.out.println("Received message: " + message);
        
        Stomp stomp = new Stomp();
        stomp.subscribe("/queue/chats" + "-" + mycustomidentifier, onmessage);
    }
}

class Stomp {
    public void subscribe(String destination, Consumer<String> onmessage) {
        // Simulation of message subscription
        System.out.println("Subscribed to: " + destination);
        // Simulate receiving a message
        onmessage.accept("Hello, this is a test message!");
    }
}