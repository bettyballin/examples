public class Temp3465 {
    public static void main(String[] args) {
        StompClient stompClient = new StompClient();
        stompClient.send("/app/chat/login", "{}", "{type: AUTH, data: {id: 'mock', pwd: '12345678'}}");
    }
}

class StompClient {
    public void send(String destination, String headers, String payload) {
        // Implementation of the send method
        System.out.println("Sending to: " + destination);
        System.out.println("Headers: " + headers);
        System.out.println("Payload: " + payload);
    }
}