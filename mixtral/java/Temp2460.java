import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.SSLSocketFactory;
import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.ssl.SSLContexts;

public class Temp2460 {
    public static void main(String[] args) {
        try {
            TrustStrategy trustStrategy = (X509Certificate[] chain, String authType) -> true;
            SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, trustStrategy).build();
            SSLSocketFactory socketFactory = createInsecureSocketFactory(sslContext);

            System.out.println("SSL Socket Factory created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SSLSocketFactory createInsecureSocketFactory(SSLContext sslContext) {
        return new SSLSocketFactory() {
            @Override
            public String[] getDefaultCipherSuites() {
                return new String[0];
            }

            @Override
            public String[] getSupportedCipherSuites() {
                return new String[0];
            }

            @Override
            public Socket createSocket(Socket s, String host, int port, boolean autoClose) {
                try {
                    return sslContext.getSocketFactory().createSocket(s, host, port, autoClose);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            public Socket createSocket(String host, int port) {
                try {
                    return sslContext.getSocketFactory().createSocket(host, port);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            public Socket createSocket(String host, int port, InetAddress localHost, int localPort) {
                try {
                    return sslContext.getSocketFactory().createSocket(host, port, localHost, localPort);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            public Socket createSocket(InetAddress host, int port) {
                try {
                    return sslContext.getSocketFactory().createSocket(host, port);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) {
                try {
                    return sslContext.getSocketFactory().createSocket(address, port, localAddress, localPort);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }
}