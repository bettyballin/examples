import java.net.Socket;
import java.io.IOException;

public class Temp1324 {
    public static void main(String[] args) {
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try (Socket socket = new Socket("example.com", 443)) {
            socket.startHandshake();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}