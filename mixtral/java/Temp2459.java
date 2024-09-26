import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLParameters;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Temp2459 {
    public static void main(String[] args) {
        // Example usage
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, null, new java.security.SecureRandom());
            SocketFactory factory = createInsecureSocketFactory(sslContext);
            Socket socket = factory.createSocket("example.com", 443);
            System.out.println("Connected: " + socket.isConnected());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final SocketFactory createInsecureSocketFactory(SSLContext sslContext) throws Exception {
        SSLSocketFactory socketFactory = (SSLSocketFactory) sslContext.getSocketFactory();

        return new javax.net.SocketFactory() {
            @Override
            public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
                final SSLSocket sslSocket = (SSLSocket) socketFactory.createSocket(host, port);

                // Disable hostname verification
                SSLParameters sslParameters = sslSocket.getSSLParameters();
                sslParameters.setEndpointIdentificationAlgorithm(null);
                sslSocket.setSSLParameters(sslParameters);

                sslSocket.startHandshake();

                return sslSocket;
            }

            @Override
            public Socket createSocket(String host, int port, java.net.InetAddress localHost, int localPort) throws IOException, UnknownHostException {
                return createSocket(host, port);
            }

            @Override
            public Socket createSocket(java.net.InetAddress host, int port) throws IOException {
                return createSocket(host.getHostName(), port);
            }

            @Override
            public Socket createSocket(java.net.InetAddress address, int port, java.net.InetAddress localAddress, int localPort) throws IOException {
                return createSocket(address.getHostName(), port);
            }
        };
    }
}