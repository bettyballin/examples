import java.io.IOException;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLSession;

public class SslClient {
    public static void main(String[] args) throws IOException, SSLException {
        try {
            SSLSocket socket = (SSLSocket) SSLSocketFactory.getDefault().createSocket("localhost", 443);
            
            // Perform the SSL handshake
            socket.startHandshake();
            
            // Get the session
            SSLSession session = socket.getSession();
            
            // Get the session ID
            byte[] sessionIdBytes = session.getId();
            StringBuilder sessionId = new StringBuilder();
            for (byte b : sessionIdBytes) {
                sessionId.append(String.format("%02x", b));
            }
            
            System.out.println("SSL connection established with session ID: " + sessionId.toString());
            
            // Close the socket
            socket.close();
        } catch (IOException | SSLException e) {
            System.err.println("Error establishing SSL connection: " + e.getMessage());
        }
    }
}