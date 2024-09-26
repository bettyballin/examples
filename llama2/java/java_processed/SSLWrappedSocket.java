import java.net.*;
import javax.net.ssl.*;
import java.io.*;

public class SSLWrappedSocket {
    public static void main(String[] args) throws Exception {
        // Create an SSL context
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, null, new java.security.SecureRandom());

        // Create an SSLSocketFactory
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

        // Create a plaintext socket
        Socket plainTextSocket = new Socket("localhost", 443);

        // Wrap the plaintext socket with an SSL/TLS socket
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(
            plainTextSocket,
            plainTextSocket.getInetAddress().getHostAddress(),
            plainTextSocket.getPort(),
            true
        );

        // Perform the secure handshake
        sslSocket.startHandshake();

        // Write and read data using the wrapped socket
        OutputStream outputStream = sslSocket.getOutputStream();
        InputStream inputStream = sslSocket.getInputStream();

        String message = "Hello world!";
        outputStream.write(message.getBytes());

        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);

        if (bytesRead != -1) {
            String response = new String(buffer, 0, bytesRead);
            System.out.println("Received: " + response);
        }

        // Close the streams and socket
        outputStream.close();
        inputStream.close();
        sslSocket.close();
        plainTextSocket.close();
    }
}