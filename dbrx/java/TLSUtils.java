import javax.net.ssl.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.*;

public class TLSUtils {

    public static void setTLSv12() {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, null, new SecureRandom());
            SSLContext.setDefault(sslContext);
            
            // Set the default socket factory to use your custom one
            HttpsURLConnection.setDefaultSSLSocketFactory(new CustomSocketFactory());

        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            System.err.println("Error setting TLS version: " + e.getMessage());
        }
    }

    static class CustomSocketFactory extends SSLSocketFactory {

        private final SSLContext sslContext;

        public CustomSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
            this.sslContext = SSLContext.getInstance("TLSv1.2");
            this.sslContext.init(null, null, new SecureRandom());
        }

        @Override
        public String[] getDefaultCipherSuites() {
            return sslContext.getDefaultSSLParameters().getCipherSuites();
        }

        @Override
        public String[] getSupportedCipherSuites() {
            return sslContext.getSupportedSSLParameters().getCipherSuites();
        }

        @Override
        public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
            return sslContext.getSocketFactory().createSocket(host, port);
        }

        @Override
        public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException, UnknownHostException {
            return sslContext.getSocketFactory().createSocket(host, port, localHost, localPort);
        }

        @Override
        public Socket createSocket(InetAddress host, int port) throws IOException {
            return sslContext.getSocketFactory().createSocket(host, port);
        }

        @Override
        public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
            return sslContext.getSocketFactory().createSocket(address, port, localAddress, localPort);
        }

        @Override
        public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
            return sslContext.getSocketFactory().createSocket(s, host, port, autoClose);
        }
    }

    public static void main(String[] args) {
        setTLSv12();
    }
}