import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import java.io.IOException;

public class Temp1578 {
    public static void main(String[] args) {
        try {
            SSLServerSocketFactory sslSrvFact = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket server = (SSLServerSocket) sslSrvFact.createServerSocket(443); // Example port number
            String[] protocols = server.getSupportedProtocols();
            String[] enabledProtocols = new String[2];
            int j = 0;
            for (String protocol : protocols) {
                if (protocol.equals("TLSv1") || protocol.equals("TLSv1.2")) {
                    enabledProtocols[j++] = protocol;
                }
            }
            server.setEnabledProtocols(java.util.Arrays.copyOf(enabledProtocols, j));
            System.out.println("Server started with protocols: " + java.util.Arrays.toString(server.getEnabledProtocols()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}